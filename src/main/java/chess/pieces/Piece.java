package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Color;
import chess.pieces.Enums.Type;

import java.util.Arrays;

abstract public class Piece {

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
        if (this.color != Color.BLACK) {
            return this.type.getWhiteRepresentation();
        }
        return this.type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isBlank() {
        return this.type == Type.NO_PIECE;
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }

    public boolean isSameColor(Piece piece) {
        return this.color == piece.color;
    }

    public boolean isKnight() {
        return this.type == Type.KNIGHT;
    }

    public boolean isPawn() {
        return this.type == Type.PAWN;
    }

    public boolean isKing() {
        return this.type == Type.KING;
    }


    public boolean equals(Object p) {
        if (!(p instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece) p;
        return this.color == piece.color && this.type == piece.type;
    }

    public abstract void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException;

}
