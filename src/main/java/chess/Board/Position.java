package chess.Board;

public class Position {
    public int rank;
    public int col;

    public Position(String loc) {
        int tmp = loc.charAt(1) - '0';
        this.rank = 8 - tmp;
        this.col = loc.charAt(0) - 'a';
    }

    private Position(int col, int rank) {
        this.rank = rank;
        this.col = col;
    }

    public int distance(Position des) {
        return Math.max(Math.abs(this.rank - des.rank), Math.abs(this.col - des.col));
    }

    public boolean inBoard() {
        if (this.rank > 8 || this.rank < 0 || this.col > 8 || this.col < 0) return false;
        return true;
    }

    public boolean inDiagonal(Position des) {
        return Math.abs(this.col - des.col) == Math.abs(this.rank - des.rank);
    }

    public boolean inSameColumn(Position des) {
        return this.col == des.col;
    }

    public boolean inSameRank(Position des) {
        return this.rank == des.rank;
    }

    public boolean inStraight(Position des) {
        return this.inSameColumn(des) || this.inSameRank(des);
    }

    public boolean inOneLine(Position des) {
        return this.inStraight(des) || this.inDiagonal(des);
    }

    public Position addDeltaStep(int delta_col, int delta_rank) {
        return new Position(this.col + delta_col, this.rank + delta_rank);
    }

}
