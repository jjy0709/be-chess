package chess;

public class Position {
    public int rank;
    public int colum;

    public Position(String loc) {
        int tmp = loc.charAt(1) - '0';
        this.rank = 8 - tmp;
        this.colum = loc.charAt(0) - 'a';
    }

    public static int distance(Position src, Position des) {
        return Math.max(Math.abs(src.rank - des.rank), Math.abs(src.colum - des.colum));
    }

    public boolean inBoard() {
        if(this.rank > 8 || this.rank < 0 || this.colum > 8 || this.colum < 0) return false;
        return true;
    }
}
