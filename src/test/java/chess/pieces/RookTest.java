package chess.pieces;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    Rook white = Rook.createWhite();
    Rook black = Rook.createBlack();

    @Test
    @DisplayName("각 색의 룩 생성")
    public void create_piece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Piece.Type.ROOK, white.getType());
        assertEquals(Piece.Type.ROOK, black.getType());
    }

    @Test
    @DisplayName("룩의 representation 테스트")
    public void getRepresentation() {
        assertEquals('r', white.getRepresentation());
        assertEquals('R', black.getRepresentation());
    }

    @Test
    @DisplayName("룩의 움직임 테스트")
    public void checkverifyPosition() {
        try {
            assertEquals(false, white.verifyMovePosition(new Position("a1"), new Position("d2")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(true, white.verifyMovePosition(new Position("a1"), new Position("a8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            assertEquals(false, black.verifyMovePosition(new Position("h8"), new Position("c7")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(true, black.verifyMovePosition(new Position("h8"), new Position("a8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}