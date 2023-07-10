package chess;

import chess.pieces.Piece;

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
        for(int i=0;i<8;i++) rank.pieces.add(Piece.createBlackPawn());
        return rank;
    }

    public static Rank createBlackPieceRank() {
        Rank rank = new Rank();
        rank.pieces.add(Piece.createBlackRook());
        rank.pieces.add(Piece.createBlackKnight());
        rank.pieces.add(Piece.createBlackBishop());
        rank.pieces.add(Piece.createBlackQueen());
        rank.pieces.add(Piece.createBlackKing());
        rank.pieces.add(Piece.createBlackBishop());
        rank.pieces.add(Piece.createBlackKnight());
        rank.pieces.add(Piece.createBlackRook());
        return rank;
    }

    public static Rank createWhitePawnRank() {
        Rank rank = new Rank();
        for(int i=0;i<8;i++) rank.pieces.add(Piece.createWhitePawn());
        return rank;
    }

    public static Rank createWhitePieceRank() {
        Rank rank = new Rank();
        rank.pieces.add(Piece.createWhiteRook());
        rank.pieces.add(Piece.createWhiteKnight());
        rank.pieces.add(Piece.createWhiteBishop());
        rank.pieces.add(Piece.createWhiteQueen());
        rank.pieces.add(Piece.createWhiteKing());
        rank.pieces.add(Piece.createWhiteBishop());
        rank.pieces.add(Piece.createWhiteKnight());
        rank.pieces.add(Piece.createWhiteRook());
        return rank;
    }

    public static Rank createBlankRank() {
        Rank rank = new Rank();
        for (int i=0;i<8;i++) rank.pieces.add(Piece.createBlank());
        return rank;
    }

    public IntStream getPawnPosition(Piece.Color color) {
        return IntStream
                .range(0, this.pieces.size())
                .filter(i -> this.pieces.get(i).equals(color == Piece.Color.WHITE?Piece.createWhitePawn():Piece.createBlackPawn()));
    }

    public double calculateScore(Piece.Color color) {
        return this.pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .mapToDouble(piece -> piece.getScore())
                .sum();
    }

    public boolean checkKingAlive(Piece.Color color) {
        return this.pieces.stream().anyMatch(piece -> color == Piece.Color.WHITE?piece.equals(Piece.createWhiteKing()):piece.equals(Piece.createBlackKing()));
    }

    public Stream<Piece> getPieceOfColor(Piece.Color color) {
        return this.pieces.stream()
                .filter(piece -> piece.getColor() == color);
    }
}
