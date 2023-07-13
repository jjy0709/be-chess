package chess.pieces.Enums;

public enum Color {
    WHITE, BLACK, NOCOLOR;

    public static Color getOpposite(Color color) {
        if(color == WHITE) {
            return BLACK;
        }
        return WHITE;
    }
}

