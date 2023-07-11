package chess.pieces;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    Knight white = Knight.createWhite();
    Knight black = Knight.createBlack();

    @Test
    @DisplayName("각 색의 나이트 생성")
    public void create_piece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Piece.Type.KNIGHT, white.getType());
        assertEquals(Piece.Type.KNIGHT, black.getType());
    }

    @Test
    @DisplayName("나이트의 representation 테스트")
    public void getRepresentation() {
        assertEquals('n', white.getPrint());
        assertEquals('N', black.getPrint());
    }

    @Test
    @DisplayName("나이킹의 움직임 테스트")
    public void checkverifyPosition() {
        assertEquals(false, white.verifyMovePosition(new Position("b1"), new Position("d1")));
        assertEquals(true, white.verifyMovePosition(new Position("b1"), new Position("a3")));

        assertEquals(false, black.verifyMovePosition(new Position("g8"), new Position("g7")));
        assertEquals(true, black.verifyMovePosition(new Position("g8"), new Position("e7")));
    }

}