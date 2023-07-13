package chess.pieces;

import chess.board.Position;

import static utils.ExceptionUtils.getExceptionForPieceNotMove;

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
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        if (!source.inDiagonal(destination)) {
            throw getExceptionForPieceNotMove(this);
        }
    }

}
