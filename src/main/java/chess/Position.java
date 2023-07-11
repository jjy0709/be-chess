package chess;

public class Position {
    public int rank;
    public int colum;

    public Position(String loc) {
        int tmp = loc.charAt(1) - '0';
        this.rank = 8 - tmp;
        this.colum = loc.charAt(0) - 'a';
    }

    public int distance(Position des) {
        return Math.max(Math.abs(this.rank - des.rank), Math.abs(this.colum - des.colum));
    }

    public boolean inBoard() {
        if(this.rank > 8 || this.rank < 0 || this.colum > 8 || this.colum < 0) return false;
        return true;
    }

    public boolean inDiagonal(Position des) {
        return Math.abs(this.colum-des.colum) == Math.abs(this.rank-des.rank);
    }

    public boolean inStraight(Position des) {
        return this.colum == des.colum || this.rank == des.rank;
    }

    public boolean inOneLine(Position des) {
        return this.inStraight(des) || this.inDiagonal(des);
    }
}
