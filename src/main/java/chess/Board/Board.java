package chess.board;

import chess.pieces.Blank;
import chess.pieces.Pawn;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> ranks = new ArrayList<Rank>();
    public static final int BOARD_ROW = 8;
    public static final int BOARD_COLUMN = 8;

    public Board() {
        for (int rankNumber = 0; rankNumber < BOARD_ROW; rankNumber++)
            this.ranks.add(Rank.createBlankRank());
    }

    public void initialize() {
        this.ranks.set(0, Rank.createBlackPieceRank());
        this.ranks.set(1, Rank.createBlackPawnRank());
        for (int rankNumber = 2; rankNumber < 6; rankNumber++)
            this.ranks.set(rankNumber, Rank.createBlankRank());
        this.ranks.set(6, Rank.createWhitePawnRank());
        this.ranks.set(7, Rank.createWhitePieceRank());
    }

    public void initializeEmpty() {
        for (int rankNumber = 0; rankNumber < BOARD_ROW; rankNumber++)
            this.ranks.set(rankNumber, Rank.createBlankRank());
    }


    // TODO: 디미터의 법칙 적용?. 메세지로 상호작용
    public Stream<Rank> getRank() {
        return this.ranks.stream();
    }

    public String getBoardString() {
        return this.ranks.stream()
                .map(Rank::getPrint)
                .map(p -> appendNewLine(p))
                .collect(Collectors.joining());
    }

    public int getPieceCount(Piece piece) {
        return this.ranks.stream()
                .mapToInt(r -> r.getPieceCount(piece))
                .sum();
    }

    public Piece getPieceAt(Position position) {
        return this.ranks.get(position.rank).getPieceAt(position);
    }

    public void movePiece(Position position, Piece piece) {
        if (piece.isPawn()) {
            ((Pawn) piece).markPawnMoved();
        }
        this.ranks.get(position.rank).move(position, piece);
    }

    public void move(Position source, Position destination) throws Exception {
        Piece pieceSource = getPieceAt(source);
        Piece pieceDestination = getPieceAt(destination);

        checkDestinationRange(destination);

        checkDestinationPieceColor(pieceSource, pieceDestination);

        verifyPieceMovePosition(source, destination, pieceSource, pieceDestination);

        if (!pieceSource.isKnight()) {
            checkPathToDestination(source, destination);
        }

        movePiece(destination, getPieceAt(source));
        movePiece(source, Blank.createBlank());
    }

    private void checkDestinationRange(Position destination) throws Exception {
        if (!destination.inBoard()) {
            throw new Exception("기물을 보드 밖으로 이동시킬 수 없습니다.");
        }
    }

    private void checkDestinationPieceColor(Piece sourcePiece, Piece destinationPiece) throws Exception {
        if (sourcePiece.isSameColor(destinationPiece)) {
            throw new Exception("이미 같은 색의 기물이 존재하는 위치입니다.");
        }
    }

    private void verifyPieceMovePosition(Position source, Position destination, Piece pieceSource,
                                         Piece pieceDestination) throws Exception {
        if (pieceSource.isPawn() && !pieceDestination.isBlank()) {
            ((Pawn) pieceSource).verifyMovePositionWhenEnemyExist(source, destination);
            return;
        }
        pieceSource.verifyMovePosition(source, destination);
    }

    private void checkPathToDestination(Position source, Position destination) throws Exception {
        int columnDiff = destination.column - source.column;
        int rankDiff = destination.rank - source.rank;
        int stepNumber = Math.max(Math.abs(columnDiff), Math.abs(rankDiff));

        int deltaColumn = columnDiff / stepNumber;
        int deltaRank = rankDiff / stepNumber;

        for (int step = 1; step < stepNumber; step++) {
            Position tmp = source.addDeltaStep(deltaColumn * step, deltaRank * step);
            if (!getPieceAt(tmp).isBlank()) {
                throw new Exception(String.format("%s은 다른 기물을 넘어 이동할 수 없습니다."));
            }
        }

    }

}
