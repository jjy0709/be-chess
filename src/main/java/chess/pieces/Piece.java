package chess.pieces;

import chess.Position;

abstract public class Piece {
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

    protected Color color;
    protected Type type;

    protected Piece(Color color) {
        this.color = color;
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

    public char getRepresentation() {
        if (this.color != Color.BLACK) return this.type.getWhiteRepresentation();
        return this.type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isKnight() {
        return this.type == Type.KNIGHT;
    }

    public boolean isPawn() {
        return this.type == Type.PAWN;
    }

    public boolean isBlank() {
        return this.type == Type.NO_PIECE;
    }

    public boolean equals(Object p) {
        if (!(p instanceof Piece)) return false;
        Piece piece = (Piece) p;
        return this.color == piece.color && this.type == piece.type;
    }

    public abstract boolean verifyMovePosition(Position src, Position dst);

//    public boolean verifyMovePiece(Position src, Position dst) {
//        if (this.type == Type.KING) {
//            if(src.distance(dst) != 1) return false;
//        } else if(this.type == Type.QUEEN) {
//            if(!src.inOneLine(dst)) return false;
//        }
//        return true;
//    }
}
