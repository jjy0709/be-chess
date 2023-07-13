package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Color;
import chess.pieces.Enums.Type;

import static utils.ExceptionUtils.getExceptionForPieceNotMove;

public class Pawn extends Piece {
    Boolean moved;

    private Pawn(Color color) {
        super(color);
        this.type = Type.PAWN;
        this.moved = false;
    }

    public static Pawn createWhite() {
        return new Pawn(Color.WHITE);
    }

    public static Pawn createBlack() {
        return new Pawn(Color.BLACK);
    }

    @Override
    public void verifyMovePosition(Position source, Position destination) throws IllegalArgumentException {
        if (verifyStepDirection(source, destination) || !source.inSameColumn(destination)
                || verifyFirstStep(source, destination)) {
            throw getExceptionForPieceNotMove(this);
        }
    }

    private boolean verifyStepDirection(Position source, Position destination) {
        return (this.isWhite() && destination.rank > source.rank)
                || (this.isBlack() && destination.rank < source.rank);
    }

    private boolean verifyFirstStep(Position source, Position destination) {
        return ((this.moved && source.distance(destination) > 1)
                || (source.distance(destination) > 2));
    }

    public void verifyMovePositionWhenEnemyExist(Position source, Position destination) throws IllegalArgumentException {
        if (verifyStepDirection(source, destination) || verifyFirstStep(source, destination)
                || !(source.inSameColumn(destination)
                || (source.distance(destination) == 1 && source.inDiagonal(destination)))) {
            throw getExceptionForPieceNotMove(this);
        }
    }

    public void markPawnMoved() {
        this.moved = true;
    }

}
