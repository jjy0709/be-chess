package chess.pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private String color;
    public Pawn(String c) {
        this.color = c;
    }
    public Pawn() {
        this.color = Pawn.WHITE;
    }

    public String getColor() {
        return this.color;
    }
}
