package chess;

import chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Rank {
    private List<Piece> pieces;

    private Rank(){
        this.pieces = new ArrayList<Piece>();
    }

    public String getPrint() {
        return this.pieces.stream().map(Piece::getPrint).map(p -> Character.toString(p)).collect(Collectors.joining());
    }

    public int getPieceCount(Piece p) {
        return (int) this.pieces.stream().filter(piece -> p.equals(piece)).count();
    }

    public Piece getPieceAt(int c) {
        return this.pieces.get(c);
    }

    public void move(int c, Piece piece) {
        this.pieces.set(c, piece);
    }

    public static Rank createBlackPawnRank() {
        Rank rank = new Rank();
        for(int i=0;i<8;i++) rank.pieces.add(Pawn.createBlack());
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
        for(int i=0;i<8;i++) rank.pieces.add(Pawn.createWhite());
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
        for (int i=0;i<8;i++) rank.pieces.add(Blank.createBlank());
        return rank;
    }

    public IntStream getPawnPosition(Piece.Color color) {
        return IntStream
                .range(0, this.pieces.size())
                .filter(i -> this.pieces.get(i).equals(color == Piece.Color.WHITE?Pawn.createWhite():Pawn.createBlack()));
    }

    public double calculateScore(Piece.Color color) {
        return this.pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .mapToDouble(piece -> piece.getScore())
                .sum();
    }

    public boolean checkKingAlive(Piece.Color color) {
        return this.pieces.stream().anyMatch(piece -> color == Piece.Color.WHITE?piece.equals(King.createWhite()):piece.equals(King.createBlack()));
    }

    public Stream<Piece> getPieceOfColor(Piece.Color color) {
        return this.pieces.stream()
                .filter(piece -> piece.getColor() == color);
    }
}
