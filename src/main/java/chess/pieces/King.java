package chess.pieces;

import chess.Position;

public class King extends Piece {

    private King(Color color) {
        super(color);
        this.type = Type.KING;
    }
    public static King createWhite() {
        return new King(Color.WHITE);
    }

    public static King createBlack() {
        return new King(Color.BLACK);
    }

    @Override
    public boolean verifyMovePosition(Position src, Position dst) {
//        if(src.distance(dst) != 1) return false;
//        return true;
        return src.distance(dst) == 1;
    }

}
