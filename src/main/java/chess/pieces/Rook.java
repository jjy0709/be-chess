package chess.pieces;

import chess.Position;

public class Rook extends Piece {
    private Rook(Color color) {
        super(color);
        this.type = Type.ROOK;
    }

    public static Rook createWhite() { return new Rook(Color.WHITE); }

    public static Rook createBlack() { return new Rook(Color.BLACK); }

    @Override
    boolean verifyMovePosition(Position src, Position dst) {
        return false;
    }
}
