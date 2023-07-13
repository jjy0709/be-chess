package chess.pieces;

import chess.board.Position;

import static utils.ExceptionUtils.getExceptionForPieceNotMove;

public class Queen extends Piece {

    private Queen(Color color) {
        super(color);
        this.type = Type.QUEEN;
    }

    public static Queen createWhite() {
        return new Queen(Color.WHITE);
    }

    public static Queen createBlack() {
        return new Queen(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        if (!source.inOneLine(destination)) {
            throw getExceptionForPieceNotMove(this);
        }
    }
}
