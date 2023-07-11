package chess.pieces;

import chess.Position;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color);
        this.type = Type.KNIGHT;
    }

    public static Knight createWhite() { return new Knight(Color.WHITE); }

    public static Knight createBlack() { return new Knight(Color.BLACK); }

    @Override
    boolean verifyMovePosition(Position src, Position dst) {
        return false;
    }
}
