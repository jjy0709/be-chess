package chess.pieces;

import chess.Position;

public class Pawn extends Piece {
    private Pawn(Color color) {
        super(color);
        this.type = Type.PAWN;
    }

    public static Pawn createWhite() { return new Pawn(Color.WHITE); }

    public static Pawn createBlack() { return new Pawn(Color.BLACK); }

    @Override
    boolean verifyMovePosition(Position src, Position dst) {
        return false;
    }
}
