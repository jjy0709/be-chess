package chess;

public class Position {
    public int rank;
    public int colum;

    public Position(String loc) {
        this.rank = 8 - loc.charAt(1) - '0';
        this.colum = loc.charAt(0) - 'a';
    }
}
