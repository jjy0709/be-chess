package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    Knight white = Knight.createWhite();
    Knight black = Knight.createBlack();

    @Test
    @DisplayName("나이트를 생성하여 타입, 색, 표현 문자를 테스트한다.")
    void createPiece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Type.KNIGHT, white.getType());
        assertEquals(Type.KNIGHT, black.getType());

        assertEquals('n', white.getRepresentation());
        assertEquals('N', black.getRepresentation());
    }

    @Test
    @DisplayName("나이트를 잘못된 위치로 이동시켰을 때 예외가 발생해야 한다.")
    void checkVerifyPositionThrowsException() {
        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("b1"), new Position("d1")));
        assertThrows(Exception.class, () -> black.verifyMovePosition(new Position("g8"), new Position("g7")));
    }

    @Test
    @DisplayName("나이트를 올바른 위치로 이동시켰을 때 예외가 발생하지 않아야 한다.")
    void checkVerifyPositionDoesNotThrowException() {
        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("b1"), new Position("a3")));
        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("g8"), new Position("e7")));
    }

}