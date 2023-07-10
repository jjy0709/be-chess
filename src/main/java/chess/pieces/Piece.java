package chess.pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.),
        ROOK('r', 5.),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.),
        QUEEN('q', 9.),
        KING('k', 0.),
        NO_PIECE('.', 0.);

        private char print;
        private double score;

        Type(char print, double score) {
            this.print = print;
            this.score = score;
        }

        public char getWhiteRepresentation() {
            return this.print;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.print);
        }

        public double getScore() {
            return this.score;
        }
    }

    private Color color;
    private Type type;


    private Piece(Color color_, Type type_) {
        this.color = color_;
        this.type = type_;
    }

    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public double getScore() {
        return this.type.getScore();
    }

    public char getPrint() {
        if (this.color != Color.BLACK)
            return this.type.getWhiteRepresentation();
        return this.type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean equals(Object p) {
        if (!(p instanceof Piece)) return false;
        Piece piece = (Piece) p;
        return this.color == piece.color && this.type == piece.type;
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }
}
