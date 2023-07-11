package chess.pieces;

import chess.Position;

public class Rook extends Piece {
    private Rook(Color color) {
        super(color);
        this.type = Type.ROOK;
    }

    public static Rook createWhite() {
        return new Rook(Color.WHITE);
    }

    public static Rook createBlack() {
        return new Rook(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws Exception {
        if(!source.inStraight(destination))
            throw new Exception(String.format("%s이 이동 가능한 곳이 아닙니다.", this.getType()));
    }
}
