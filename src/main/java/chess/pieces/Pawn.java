package chess.pieces;

import chess.ChessGame;
import chess.board.Position;

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

        if (!source.inStraight(destination))
            verifyPawnSideStep(source, destination);

        verifyFirstStep(source, destination);
        this.moved = true;
    }

    private void verifyStepDirection(Position source, Position destination) throws Exception {
        if ((this.isWhite() && destination.rank > source.rank) ||
                (this.isBlack() && destination.rank < source.rank))
            throw new Exception("PAWN은 앞으로만 움직일 수 있습니다.");
    }

    private void verifyPawnSideStep(Position source, Position destination) throws Exception {
        if (!(source.distance(destination) == 1 && source.inDiagonal(destination)))
            throw new Exception("PAWN이 이동할 수 없는 위치입니다.");
        if (!ChessGame.checkPieceExist(destination))
            throw new Exception("PAWN은 적이 없는 경우 대각선으로 움직일 수 없습니다.");
    }

    private void verifyFirstStep(Position source, Position destination) throws Exception {
        if ((this.moved && source.distance(destination) > 1)
                || (source.distance(destination) > 2))
            throw new Exception("PAWN은 처음에만 최대 두 칸 움직일 수 있습니다.");
    }

}
