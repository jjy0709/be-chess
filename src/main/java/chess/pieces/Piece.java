package chess.pieces;

public class Piece {
    public static final String WHITE = "white";
    public static final char WHITE_PRINT = 'p';
    public static final String BLACK = "black";
    public static final char BLACK_PRINT = 'P';
    private String color;
    private char print;
    private String type; // pawn, knight, rook, bishop, queen, king


    private Piece(String color_, String type_) {
        this.color = color_;
//        this.print = color_ == Piece.WHITE? Piece.WHITE_PRINT: Piece.BLACK_PRINT;
        this.type = type_;
    }

    public String getColor() {
        return this.color;
    }
    public char getPrint() { return this.print; }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, "pawn");
    }
    public static Piece createBlackPawn() {
        return new Piece(BLACK, "pawn");
    }
}
