package chess.pieces;

import chess.board.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.pieces.Enums.Type.BISHOP;
import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    Bishop white = Bishop.createWhite();
    Bishop black = Bishop.createBlack();

    @Test
    @DisplayName("비숍을 생성하여 타입, 색, 표현 문자를 테스트한다.")
    void createPiece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(BISHOP, white.getType());
        assertEquals(BISHOP, black.getType());

        assertEquals('b', white.getRepresentation());
        assertEquals('B', black.getRepresentation());
    }

    @Test
    @DisplayName("비숍을 잘못된 위치로 이동시켰을 때 예외가 발생해야 한다.")
    void checkVerifyPositionThrowsException() {
        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("c1"), new Position("d1")));
        assertThrows(Exception.class, () -> black.verifyMovePosition(new Position("c8"), new Position("c7")));
    }

    @Test
    @DisplayName("비숍을 올바른 위치로 이동시켰을 때 예외가 발생하지 않아야 한다.")
    void checkVerifyPositionDoesNotThrowException() {
        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("c1"), new Position("a3")));
        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("c8"), new Position("e6")));
    }

}