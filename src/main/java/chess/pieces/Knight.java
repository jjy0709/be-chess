package chess.pieces;

import chess.board.Position;

import static utils.ExceptionUtils.getExceptionForPieceNotMove;

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
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        if (!(source.distance(destination) == 2 && !source.inOneLine(destination))) {
            throw getExceptionForPieceNotMove(this);
        }
    }
}
