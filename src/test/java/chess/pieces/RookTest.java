package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    Rook white = Rook.createWhite();
    Rook black = Rook.createBlack();

    @Test
    @DisplayName("룩을 생성하여 타입, 색, 표현 문자를 테스트한다.")
    void createPiece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Type.ROOK, white.getType());
        assertEquals(Type.ROOK, black.getType());

        assertEquals('r', white.getRepresentation());
        assertEquals('R', black.getRepresentation());
    }

    @Test
    @DisplayName("룩을 잘못된 위치로 이동시켰을 때 예외가 발생해야 한다.")
    public void checkVerifyPositionThrowsException() {
        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("a1"), new Position("d2")));
        assertThrows(Exception.class, () -> black.verifyMovePosition(new Position("h8"), new Position("c7")));
    }

    @Test
    @DisplayName("룩을 올바른 위치로 이동시켰을 때 예외가 발생하지 않아야 한다.")
    void checkVerifyPositionDoesNotThrowException() {
        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("a1"), new Position("a8")));
        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("h8"), new Position("a8")));
    }

}