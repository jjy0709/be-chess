package chess.pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }
    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private char print;

        Type(char print) {
            this.print = print;
        }

        public char getWhiteRepresentation() {
            return this.print;
        }
        public char getBlackRepresentation() {
            return Character.toUpperCase(this.print);
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
    public char getPrint() {
        if(this.color != Color.BLACK)
            return this.type.getWhiteRepresentation();
        return this.type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }
    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }
    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT);
    }
    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT);
    }
    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK);
    }
    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK);
    }
    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP);
    }
    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP);
    }
    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN);
    }
    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN);
    }
    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING);
    }
    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING);
    }
}
