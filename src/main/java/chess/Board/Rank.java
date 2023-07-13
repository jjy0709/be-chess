package chess.board;

import chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static chess.board.Board.BOARD_COLUMN;

public class Rank {
    private List<Piece> pieces;

    private Rank() {
        this.pieces = new ArrayList<Piece>();
    }

    public String getPrint() {
        return this.pieces.stream()
                .map(Piece::getRepresentation)
                .map(piece -> Character.toString(piece))
                .collect(Collectors.joining());
    }

    public int getPieceCount(Piece piece) {
        return (int) this.pieces.stream()
                .filter(pieceCompare -> piece.equals(pieceCompare))
                .count();
    }

    public Piece getPieceAt(Position position) {
        return this.pieces.get(position.column);
    }

    public void move(Position position, Piece piece) {
        this.pieces.set(position.column, piece);
    }

    public static Rank createBlackPawnRank() {
        Rank rank = new Rank();
        for (int column = 0; column < BOARD_COLUMN; column++) {
            rank.pieces.add(Pawn.createBlack());
        }
        return rank;
    }

    public static Rank createBlackPieceRank() {
        Rank rank = new Rank();
        rank.pieces.add(Rook.createBlack());
        rank.pieces.add(Knight.createBlack());
        rank.pieces.add(Bishop.createBlack());
        rank.pieces.add(Queen.createBlack());
        rank.pieces.add(King.createBlack());
        rank.pieces.add(Bishop.createBlack());
        rank.pieces.add(Knight.createBlack());
        rank.pieces.add(Rook.createBlack());
        return rank;
    }

    public static Rank createWhitePawnRank() {
        Rank rank = new Rank();
        for (int column = 0; column < BOARD_COLUMN; column++) {
            rank.pieces.add(Pawn.createWhite());
        }
        return rank;
    }

    public static Rank createWhitePieceRank() {
        Rank rank = new Rank();
        rank.pieces.add(Rook.createWhite());
        rank.pieces.add(Knight.createWhite());
        rank.pieces.add(Bishop.createWhite());
        rank.pieces.add(Queen.createWhite());
        rank.pieces.add(King.createWhite());
        rank.pieces.add(Bishop.createWhite());
        rank.pieces.add(Knight.createWhite());
        rank.pieces.add(Rook.createWhite());
        return rank;
    }

    public static Rank createBlankRank() {
        Rank rank = new Rank();
        for (int column = 0; column < BOARD_COLUMN; column++) {
            rank.pieces.add(Blank.createBlank());
        }
        return rank;
    }

    public IntStream getPawnPosition(Piece.Color color) {
        return IntStream
                .range(0, BOARD_COLUMN)
                .filter(index -> {
                    Piece piece = this.pieces.get(index);
                    return piece.isColor(color) && piece.isPawn();
                });
    }

    public double calculateScore(Piece.Color color) {
        return this.pieces.stream()
                .filter(piece -> piece.isColor(color))
                .mapToDouble(piece -> piece.getScore())
                .sum();
    }

    public boolean checkKingAlive(Piece.Color color) {
        return this.pieces.stream()
                .anyMatch(piece -> piece.isColor(color) && piece.isKing());
    }

    public Stream<Piece> getPieceOfColor(Piece.Color color) {
        return this.pieces.stream()
                .filter(piece -> piece.isColor(color));
    }
}
