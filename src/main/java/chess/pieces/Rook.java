package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Color;
import chess.pieces.Enums.Type;

import static utils.ExceptionUtils.getExceptionForPieceNotMove;

public class Rook extends Piece {
    private Rook(Color color) {
        super(color);
        this.type = Type.ROOK;
    }

    public static Rook createWhite() {
        return new Rook(Color.WHITE);
    }

    public static Rook createBlack() {
        return new Rook(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        if (!source.inStraight(destination)) {
            throw getExceptionForPieceNotMove(this);
        }
    }
}
