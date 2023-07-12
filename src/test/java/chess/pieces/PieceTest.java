package chess.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("같은 종류의 piece에 대해 equals가 잘 작동하는지 테스트한다.")
    void checkEqualOfSamePiece() {
        assertTrue(Pawn.createBlack().equals(Pawn.createBlack()));
        assertTrue(Rook.createBlack().equals(Rook.createBlack()));
        assertTrue(Knight.createBlack().equals(Knight.createBlack()));
        assertTrue(Bishop.createWhite().equals(Bishop.createWhite()));
        assertTrue(King.createWhite().equals(King.createWhite()));
        assertTrue(Queen.createWhite().equals(Queen.createWhite()));
        assertTrue(Blank.createBlank().equals(Blank.createBlank()));
    }
}