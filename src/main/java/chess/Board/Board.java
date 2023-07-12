package chess.Board;

import chess.pieces.Blank;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> ranks = new ArrayList<Rank>();

    public Board() {
    }

    public void initialize() {
        this.ranks.add(Rank.createBlackPieceRank());
        this.ranks.add(Rank.createBlackPawnRank());
        for (int i = 0; i < 4; i++)
            this.ranks.add(Rank.createBlankRank());
        this.ranks.add(Rank.createWhitePawnRank());
        this.ranks.add(Rank.createWhitePieceRank());
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) this.ranks.add(Rank.createBlankRank());
    }

    public Stream<Rank> getRank() {
        return this.ranks.stream();
    }

    public String getBoardString() {
        return this.ranks.stream()
                .map(Rank::getPrint)
                .map(p -> appendNewLine(p))
                .collect(Collectors.joining());
    }

    public int getPieceCount(Piece p) {
        return this.ranks.stream().mapToInt(r -> r.getPieceCount(p)).sum();
    }

    public Piece getPieceAt(Position position) {
        return this.ranks.get(position.rank).getPieceAt(position);
    }

    public void movePiece(Position position, Piece piece) {
        this.ranks.get(position.rank).move(position, piece);
    }

    public void move(Position source, Position destination) throws Exception {
        Piece pieceSource = getPieceAt(source);
        Piece pieceDestination = getPieceAt(destination);

        checkDestinationRange(destination);

        checkDestinationPieceColor(pieceSource, pieceDestination);

        pieceSource.verifyMovePosition(source, destination);

        if (!pieceSource.isKnight())
            checkPathToDestination(source, destination);

        movePiece(destination, getPieceAt(source));
        movePiece(source, Blank.createBlank());
    }

    private void checkDestinationRange(Position destination) throws Exception {
        if (!destination.inBoard())
            throw new Exception("기물을 보드 밖으로 이동시킬 수 없습니다.");
    }

    private void checkDestinationPieceColor(Piece sourcePiece, Piece destinationPiece) throws Exception {
        if (sourcePiece.getColor() == destinationPiece.getColor())
            throw new Exception("이미 같은 색의 기물이 존재하는 위치입니다.");
    }

    private void checkPathToDestination(Position source, Position destination) throws Exception {
        int columnDiff = destination.col - source.col;
        int rankDiff = destination.rank - source.rank;
        int stepNumber = Math.max(Math.abs(columnDiff), Math.abs(rankDiff));

        int deltaColumn = columnDiff / stepNumber;
        int deltaRank = rankDiff / stepNumber;

        for (int i = 1; i < stepNumber; i++) {
            Position tmp = source.addDeltaStep(deltaColumn * i, deltaRank * i);
            if (!getPieceAt(tmp).equals(Blank.createBlank()))
                throw new Exception(String.format("%s은 다른 기물을 넘어 이동할 수 없습니다."));
        }

    }

}
