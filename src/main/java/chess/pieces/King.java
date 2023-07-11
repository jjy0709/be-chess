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
    public void verifyMovePosition(Position source, Position destination) throws Exception {
        if(source.distance(destination) != 1)
            throw new Exception(String.format("%s이 이동 가능한 곳이 아닙니다.", this.getType()));
    }

}
