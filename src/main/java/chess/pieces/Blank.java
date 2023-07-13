package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Color;
import chess.pieces.Enums.Type;

public class Blank extends Piece {
    private Blank(Color color) {
        super(color);
        this.type = Type.NO_PIECE;
    }

    public static Blank createBlank() {
        return new Blank(Color.NOCOLOR);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        return;
    }
}
