package chess.pieces;

import chess.Board.Position;

public class Blank extends Piece {
    private Blank(Color color) {
        super(color);
        this.type = Type.NO_PIECE;
    }

    public static Blank createBlank() {
        return new Blank(Color.NOCOLOR);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws Exception {
        return;
    }
}
