package chess.pieces;

import chess.Position;

public class Pawn extends Piece {
    Boolean moved;
    private Pawn(Color color) {
        super(color);
        this.type = Type.PAWN;
        this.moved = false;
    }

    public static Pawn createWhite() { return new Pawn(Color.WHITE); }

    public static Pawn createBlack() { return new Pawn(Color.BLACK); }

    @Override
    public boolean verifyMovePosition(Position src, Position dst) {
        // 앞으로만 갈 수 있다.
        // 한 번도 움직이지 않은 폰은 두 칸 움직일 수 있다.
        // 이미 움직인 폰은 한 칸만 움직일 수 있다.(앞이 비었을 때)
        if(src.colum != dst.colum) return false;
        if(this.isWhite() && dst.rank > src.rank) return false;
        if(this.isBlack() && dst.rank < src.rank) return false;
        if(this.moved && Math.abs(dst.rank - src.rank) != 1) return false;
        if(Math.abs(dst.rank - src.rank) > 2) return false;
        this.moved = true;
        return true;
    }

    public boolean verifyMovePositionBlank(Position src, Position dst) {
        // 대각선에 적이 있으면 잡으면서 움직일 수 있다. -> 적이 없으면 불가능.

        return true;
    }
}
