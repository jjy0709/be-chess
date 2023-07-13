package chess.pieces;

import chess.board.Position;

import static utils.ExceptionUtils.getExceptionForPieceNotMove;

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
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        if (source.distance(destination) != 1) {
            throw getExceptionForPieceNotMove(this);
        }
    }

}
