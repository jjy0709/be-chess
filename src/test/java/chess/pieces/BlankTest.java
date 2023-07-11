package chess.pieces;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlankTest {
    Blank blank = Blank.createBlank();

    @Test
    @DisplayName("빈 칸 생성")
    public void create_piece() {
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());

        assertEquals(Piece.Type.NO_PIECE, blank.getType());
    }

    @Test
    @DisplayName("빈 칸의 representation 테스트")
    public void getRepresentation() {
        assertEquals('.', blank.getRepresentation());
    }

    @Test
    @DisplayName("빈 칸은 어디든지 움직일 수 있다.")
    public void checkverifyPosition() {
        assertEquals(true, blank.verifyMovePosition(new Position("c1"), new Position("d1")));
        assertEquals(true, blank.verifyMovePosition(new Position("c1"), new Position("a3")));

        assertEquals(true, blank.verifyMovePosition(new Position("c8"), new Position("c7")));
        assertEquals(true, blank.verifyMovePosition(new Position("c8"), new Position("e6")));
    }
}