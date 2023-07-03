package softeer2nd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("create white pawn")
    public void create() {
        String white = "white";
        String black = "black";

        verifyPawn(white);
        verifyPawn(black);
    }

    public static void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}