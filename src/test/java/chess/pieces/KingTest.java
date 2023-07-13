package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    King white = King.createWhite();
    King black = King.createBlack();

    @Test
    @DisplayName("킹을 생성하여 타입, 색, 표현 문자를 테스트한다.")
    void createPiece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Type.KING, white.getType());
        assertEquals(Type.KING, black.getType());

        assertEquals('k', white.getRepresentation());
        assertEquals('K', black.getRepresentation());
    }

    @Test
    @DisplayName("킹을 잘못된 위치로 이동시켰을 때 예외가 발생해야 한다.")
    void checkVerifyPositionThrowsException() {
        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("e1"), new Position("c2")));
        assertThrows(Exception.class, () -> black.verifyMovePosition(new Position("e8"), new Position("e6")));
    }

    @Test
    @DisplayName("킹을 올바른 위치로 이동시켰을 때 예외가 발생하지 않아야 한다.")
    void checkVerifyPositionDoesNotThrowException() {
        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("e1"), new Position("e2")));
        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("e8"), new Position("d7")));
    }
}