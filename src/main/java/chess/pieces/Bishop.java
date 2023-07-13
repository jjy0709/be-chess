package chess.pieces;

import chess.board.Position;

public class Bishop extends Piece {

    private Bishop(Color color) {
        super(color);
        this.type = Type.BISHOP;
    }

    public static Bishop createWhite() {
        return new Bishop(Color.WHITE);
    }

    public static Bishop createBlack() {
        return new Bishop(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws Exception {
        if (!source.inDiagonal(destination)) {
            throw new Exception(String.format("%s이 이동 가능한 곳이 아닙니다.", this.getType()));
        }
    }

}
