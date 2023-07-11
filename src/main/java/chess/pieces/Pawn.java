package chess.pieces;

import chess.ChessGame;
import chess.Position;

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
        // 앞으로만 갈 수 있다.
        // 한 번도 움직이지 않은 폰은 두 칸 움직일 수 있다.
        // 이미 움직인 폰은 한 칸만 움직일 수 있다.(앞이 비었을 때)
        verifyStepDirection(source, destination);

        if(verifySideStep(source, destination))
            return;

        if (source.col != destination.col)
            throw new Exception("폰은 앞으로만 움직일 수 있습니다.");

        verifyFirstStep(source, destination);
        this.moved = true;
    }

    private boolean verifySideStep(Position source, Position destination) throws Exception {
        Piece enemy = ChessGame.getPieceAtPosition(destination);
        if(!enemy.isBlank() && source.distance(destination) == 1
                    && source.inDiagonal(destination)) return true;
        return false;
    }

    private void verifyStepDirection(Position source, Position destination) throws Exception {
        if ((this.isWhite() && destination.rank > source.rank) ||
                (this.isBlack() && destination.rank < source.rank))
            throw new Exception("폰은 앞으로만 움직일 수 있습니다.");
    }

    private void verifyFirstStep(Position source, Position destination) throws Exception {
        if ((this.moved && Math.abs(destination.rank - source.rank) > 1) ||
                (Math.abs(destination.rank - source.rank) > 2))
            throw new Exception("폰은 처음에만 최대 두 칸 움직일 수 있습니다.");
    }

}
