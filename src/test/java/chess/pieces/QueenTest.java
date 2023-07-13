package chess.pieces;

import chess.board.Position;
import chess.pieces.Enums.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    Queen white = Queen.createWhite();
    Queen black = Queen.createBlack();

    @Test
    @DisplayName("퀸을 생성하여 타입, 색, 표현 문자를 테스트한다.")
    void createPiece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Type.QUEEN, white.getType());
        assertEquals(Type.QUEEN, black.getType());

        assertEquals('q', white.getRepresentation());
        assertEquals('Q', black.getRepresentation());
    }

    @Test
    @DisplayName("퀸을 잘못된 위치로 이동시켰을 때 예외가 발생해야 한다.")
    void checkVerifyPositionThrowsException() {
        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("d1"), new Position("a3")));
        assertThrows(Exception.class, () -> black.verifyMovePosition(new Position("d8"), new Position("e2")));
    }

    @Test
    @DisplayName("퀸을 올바른 위치로 이동시켰을 때 예외가 발생하지 않아야 한다.")
    void checkVerifyPositionDoesNotThrowException() {
        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("d1"), new Position("d8")));
        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("d8"), new Position("h4")));
    }

}