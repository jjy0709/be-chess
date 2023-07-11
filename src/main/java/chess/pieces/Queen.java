package chess.pieces;

import chess.Position;

public class Queen extends Piece{

    private Queen(Color color) {
        super(color);
        this.type = Type.QUEEN;
    }

    public static Queen createWhite() { return new Queen(Color.WHITE); }

    public static Queen createBlack() { return new Queen(Color.BLACK); }

    @Override
    boolean verifyMovePosition(Position src, Position dst) {
//        if(!src.inOneLine(dst)) return false;
//        return true;
        return src.inOneLine(dst);
    }
}
