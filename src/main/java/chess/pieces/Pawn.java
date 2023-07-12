package chess.pieces;

import chess.Board.Position;
import chess.ChessGame;

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
    public void verifyMovePosition(Position source, Position destination) throws Exception {
        verifyStepDirection(source, destination);

        if (verifyPawnSideStep(source, destination))
            return;

        if (source.col != destination.col)
            throw new Exception("PAWN은 앞으로만 움직일 수 있습니다.");

        verifyFirstStep(source, destination);
        this.moved = true;
    }

    private boolean verifyPawnSideStep(Position source, Position destination) throws Exception {
        if (!ChessGame.checkPieceColorDiffer(this, destination)
                && source.distance(destination) == 1 && source.inDiagonal(destination))
            throw new Exception("PAWN은 적이 없는 경우 대각선으로 움직일 수 없습니다.");
        return false;
    }

    private void verifyStepDirection(Position source, Position destination) throws Exception {
        if ((this.isWhite() && destination.rank > source.rank) ||
                (this.isBlack() && destination.rank < source.rank))
            throw new Exception("PAWN은 앞으로만 움직일 수 있습니다.");
    }

    private void verifyFirstStep(Position source, Position destination) throws Exception {
        if ((this.moved && Math.abs(destination.rank - source.rank) > 1) ||
                (Math.abs(destination.rank - source.rank) > 2))
            throw new Exception("PAWN은 처음에만 최대 두 칸 움직일 수 있습니다.");
    }

}
