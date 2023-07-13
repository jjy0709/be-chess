package chess.board;

public class Position {
    public int rank;
    public int column;

    public Position(String loc) {
        int tmp = loc.charAt(1) - '0';
        this.rank = 8 - tmp;
        this.column = loc.charAt(0) - 'a';
    }

    private Position(int column, int rank) {
        this.rank = rank;
        this.column = column;
    }

    public int distance(Position destination) {
        return Math.max(Math.abs(this.rank - destination.rank), Math.abs(this.column - destination.column));
    }

    public boolean inBoard() {
        return !(this.rank > 8 || this.rank < 0 || this.column > 8 || this.column < 0);
    }

    public boolean inDiagonal(Position destination) {
        return Math.abs(this.column - destination.column) == Math.abs(this.rank - destination.rank);
    }

    public boolean inSameColumn(Position destination) {
        return this.column == destination.column;
    }

    public boolean inSameRank(Position destination) {
        return this.rank == destination.rank;
    }

    public boolean inStraight(Position destination) {
        return this.inSameColumn(destination) || this.inSameRank(destination);
    }

    public boolean inOneLine(Position destination) {
        return this.inStraight(destination) || this.inDiagonal(destination);
    }

    public Position addDeltaStep(int delta_column, int delta_rank) {
        return new Position(this.column + delta_column, this.rank + delta_rank);
    }

}
