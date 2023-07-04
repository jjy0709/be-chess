package chess.pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final char WHITE_PRINT = 'p';
    public static final String BLACK = "black";
    public static final char BLACK_PRINT = 'P';
    private String color;
    private char print;

    public Pawn(String c) {
        this.color = c;
        this.print = c == Pawn.WHITE?Pawn.WHITE_PRINT:Pawn.BLACK_PRINT;
    }
    public Pawn() {
        this.color = Pawn.WHITE;
        this.print = Pawn.WHITE_PRINT;
    }
    public String getColor() {
        return this.color;
    }
    public char getPrint() { return this.print; }
}
