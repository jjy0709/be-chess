package chess.pieces;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    Pawn white = Pawn.createWhite();
    Pawn black = Pawn.createBlack();

    @Test
    @DisplayName("각 색의 폰 생성")
    public void create_piece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Piece.Type.PAWN, white.getType());
        assertEquals(Piece.Type.PAWN, black.getType());
    }

    @Test
    @DisplayName("폰의 representation 테스트")
    public void getRepresentation() {
        assertEquals('p', white.getPrint());
        assertEquals('P', black.getPrint());
    }

    @Test
    @DisplayName("폰의 움직임 테스트")
    public void checkverifyPosition() {
        assertEquals(true, white.verifyMovePosition(new Position("c2"), new Position("c4")));
        assertEquals(false, white.verifyMovePosition(new Position("c4"), new Position("c6")));
        assertEquals(true, white.verifyMovePosition(new Position("c4"), new Position("c5")));

        assertEquals(true, black.verifyMovePosition(new Position("e7"), new Position("e5")));
        assertEquals(false, black.verifyMovePosition(new Position("e5"), new Position("e3")));
        assertEquals(true, black.verifyMovePosition(new Position("e5"), new Position("e4")));
    }

}