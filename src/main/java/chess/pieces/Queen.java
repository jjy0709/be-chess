package chess.pieces;

import chess.Position;

public class Queen extends Piece {

    private Queen(Color color) {
        super(color);
        this.type = Type.QUEEN;
    }

    public static Queen createWhite() {
        return new Queen(Color.WHITE);
    }

    public static Queen createBlack() {
        return new Queen(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws Exception {
//        if(!src.inOneLine(dst)) return false;
//        return true;
        if(!source.inOneLine(destination))
            throw new Exception(String.format("%s이 이동 가능한 곳이 아닙니다.", this.getType()));
    }
}
