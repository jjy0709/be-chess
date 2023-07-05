package chess;

public class Position {
    public int rank;
    public int colum;

    public Position(String loc) {
        int tmp = loc.charAt(1) - '0';
        this.rank = 8 - tmp;
        this.colum = loc.charAt(0) - 'a';
    }
}
