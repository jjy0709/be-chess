package chess;

import chess.pieces.Blank;
import chess.pieces.Pawn;
import chess.pieces.Piece;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        Piece piece = getPieceAt(source);

        if (!destination.inBoard()) throw new Exception("Destination out of the board!");
        if (piece.getColor() == getPieceAt(destination).getColor())
            throw new Exception("You cannot move your piece to already existing location");

        if (!piece.verifyMovePosition(source, destination))
            throw new Exception(String.format("You cannot move %s in that location", piece.getType()));
        if (!piece.isKnight() && !checkPathToDestination(source, destination))
            throw new Exception("path blocked to that location");
        if (piece.isPawn()) ((Pawn) piece).verifyMovePositionBlank(source, destination);

        movePiece(destination, getPieceAt(source));
        movePiece(source, Blank.createBlank());
    }

    private boolean checkPathToDestination(Position source, Position destination) {
        int columnDiff = destination.col - source.col;
        int rankDiff = destination.rank - source.rank;
        int stepNumber = Math.max(Math.abs(columnDiff), Math.abs(rankDiff));

        int deltaColumn = columnDiff / stepNumber;
        int deltaRank = rankDiff / stepNumber;

        for (int i = 1; i < stepNumber; i++) {
            Position tmp = source.addDeltaStep(deltaColumn * i, deltaRank * i);
            if (!getPieceAt(tmp).equals(Blank.createBlank()))
                return false;
        }
        return true;

//        IntStream rankRange = IntStream.range(source.rank + 1, destination.rank);
//        IntStream colRange = IntStream.range(source.col + 1, destination.col);
//

    }

}
