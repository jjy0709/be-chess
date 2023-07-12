package chess.pieces;

import chess.Board.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    Queen white = Queen.createWhite();
    Queen black = Queen.createBlack();

    @Test
    @DisplayName("각 색의 퀸 생성")
    public void create_piece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Piece.Type.QUEEN, white.getType());
        assertEquals(Piece.Type.QUEEN, black.getType());
    }

    @Test
    @DisplayName("퀸의 representation 테스트")
    public void getRepresentation() {
        assertEquals('q', white.getRepresentation());
        assertEquals('Q', black.getRepresentation());
    }

    @Test
    @DisplayName("퀸의 움직임 테스트")
    public void checkverifyPosition() {
        try {
            assertEquals(false, white.verifyMovePosition(new Position("d1"), new Position("a3")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(true, white.verifyMovePosition(new Position("d1"), new Position("d8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            assertEquals(false, black.verifyMovePosition(new Position("d8"), new Position("e2")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(true, black.verifyMovePosition(new Position("d8"), new Position("h4")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}