package chess.pieces;

public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String PAWN = "pawn";
    public static final String KNIGHT = "knight";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";
    public static final char WHITE_PRINT = 'p';
    public static final char BLACK_PRINT = 'P';
    private String color;
    private char print;
    private String type; // pawn, knight, rook, bishop, queen, king


    private Piece(String color_, String type_) {
        this.color = color_;
        this.print = color_ == Piece.WHITE? Piece.WHITE_PRINT: Piece.BLACK_PRINT;
        this.type = type_;
    }

    public String getColor() {
        return this.color;
    }
    public char getPrint() { return this.print; }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN);
    }
    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN);
    }
    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT);
    }
    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT);
    }
    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK);
    }
    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK);
    }
    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP);
    }
    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP);
    }
    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN);
    }
    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN);
    }
    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING);
    }
    public static Piece createBlackKing() {
        return new Piece(BLACK, KING);
    }
}
