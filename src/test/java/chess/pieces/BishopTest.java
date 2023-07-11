package chess.pieces;

import chess.Position;
import chess.pieces.Piece.Type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    Bishop white = Bishop.createWhite();
    Bishop black = Bishop.createBlack();

    @Test
    @DisplayName("각 색의 비숍 생성")
    public void create_piece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Type.BISHOP, white.getType());
        assertEquals(Type.BISHOP, black.getType());
    }

    @Test
    @DisplayName("비숍의 representation 테스트")
    public void getRepresentation() {
        assertEquals('b', white.getRepresentation());
        assertEquals('B', black.getRepresentation());
    }

    @Test
    @DisplayName("비숍의 움직임 테스트")
    public void checkverifyPosition() {
        assertEquals(false, white.verifyMovePosition(new Position("c1"), new Position("d1")));
        assertEquals(true, white.verifyMovePosition(new Position("c1"), new Position("a3")));

        assertEquals(false, black.verifyMovePosition(new Position("c8"), new Position("c7")));
        assertEquals(true, black.verifyMovePosition(new Position("c8"), new Position("e6")));
    }

}