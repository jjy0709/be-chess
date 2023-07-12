package chess.pieces;

import chess.board.Position;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlankTest {
    Blank blank = Blank.createBlank();

    @Test
    @DisplayName("빈 칸이 알맞게 생성되었는지 테스트한다.")
    void createPiece() {
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());

        assertEquals(Type.NO_PIECE, blank.getType());

        assertEquals('.', blank.getRepresentation());
    }

    @Test
    @DisplayName("빈 칸을 움직여서 예외가 발생하지 않는 것을 테스트한다.")
    void checkVerifyPositionDoesNotThrowException() {
        assertDoesNotThrow(() -> blank.verifyMovePosition(new Position("c1"), new Position("d1")));
        assertDoesNotThrow(() -> blank.verifyMovePosition(new Position("c1"), new Position("a3")));
        assertDoesNotThrow(() -> blank.verifyMovePosition(new Position("c8"), new Position("c7")));
        assertDoesNotThrow(() -> blank.verifyMovePosition(new Position("c8"), new Position("e6")));
    }
}