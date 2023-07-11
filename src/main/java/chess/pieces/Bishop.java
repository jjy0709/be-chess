package chess.pieces;

import chess.Position;

public class Bishop extends Piece {

    private Bishop(Color color) {
        super(color);
        this.type = Type.BISHOP;
    }

    public static Bishop createWhite() { return new Bishop(Color.WHITE); }

    public static Bishop createBlack() { return new Bishop(Color.BLACK); }

    @Override
    boolean verifyMovePosition(Position src, Position dst) {
        return false;
    }

}
