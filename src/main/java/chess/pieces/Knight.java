package chess.pieces;

import chess.board.Position;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color);
        this.type = Type.KNIGHT;
    }

    public static Knight createWhite() {
        return new Knight(Color.WHITE);
    }

    public static Knight createBlack() {
        return new Knight(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws Exception {
        if (!(source.distance(destination) == 2 && !source.inOneLine(destination)))
            throw new Exception(String.format("%s가 이동 가능한 곳이 아닙니다.", this.getType()));
    }
}
