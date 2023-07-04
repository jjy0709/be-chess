package chess.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("create pawn with colors")
    public void create() {
        verifyPawn(Piece.WHITE, Piece.WHITE_PRINT);
        verifyPawn(Piece.BLACK, Piece.BLACK_PRINT);
    }

    public static void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color);
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getPrint());
    }

    @Test
    @DisplayName("create pawn without color")
    public void create_noColor() {
        Piece piece = new Piece();
        assertEquals(Piece.WHITE, piece.getColor());
        assertEquals(Piece.WHITE_PRINT, piece.getPrint());
    }
}