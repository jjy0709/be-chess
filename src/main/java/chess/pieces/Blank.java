package chess.pieces;

import chess.Position;

public class Blank extends Piece {
    private Blank(Color color) {
        super(color);
        this.type = Type.NO_PIECE;
    }

    public static Blank createBlank() {
        return new Blank(Color.NOCOLOR);
    }

    @Override
    public boolean verifyMovePosition(Position src, Position dst) {
        return true;
    }
}
