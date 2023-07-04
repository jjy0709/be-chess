package chess.pieces;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("create pawn with colors")
    public void create() {
        verifyPawn(Pawn.WHITE, Pawn.WHITE_PRINT);
        verifyPawn(Pawn.BLACK, Pawn.BLACK_PRINT);
    }

    public static void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getPrint());
    }

    @Test
    @DisplayName("create pawn without color")
    public void create_noColor() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor());
        assertEquals(Pawn.WHITE_PRINT, pawn.getPrint());
    }
}