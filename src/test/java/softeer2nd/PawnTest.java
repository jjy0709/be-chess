package softeer2nd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("create white pawn")
    public void create() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");

        Pawn pawn2 = new Pawn("black");
        assertThat(pawn2.getColor()).isEqualTo("black");
    }
}