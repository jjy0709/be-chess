package chess.pieces;

import chess.Position;
import chess.pieces.Piece.Type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    King white = King.createWhite();
    King black = King.createBlack();

    @Test
    @DisplayName("각 색의 킹 생성")
    public void create_piece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Piece.Type.KING, white.getType());
        assertEquals(Piece.Type.KING, black.getType());
    }

    @Test
    @DisplayName("킹의 representation 테스트")
    public void getRepresentation() {
        assertEquals('k', white.getPrint());
        assertEquals('K', black.getPrint());
    }

    @Test
    @DisplayName("킹의 움직임 테스트")
    public void checkverifyPosition() {
        assertEquals(false, white.verifyMovePosition(new Position("e1"), new Position("c2")));
        assertEquals(true, white.verifyMovePosition(new Position("e1"), new Position("e2")));

        assertEquals(false, black.verifyMovePosition(new Position("e8"), new Position("e6")));
        assertEquals(true, black.verifyMovePosition(new Position("e8"), new Position("d8트")));
    }
}