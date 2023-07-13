package chess.board;

import chess.pieces.Enums.Color;
import chess.pieces.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {
    Rank blackPawnRank = Rank.createBlackPawnRank();
    Rank blackPieceRank = Rank.createBlackPieceRank();
    Rank whitePawnRank = Rank.createWhitePawnRank();
    Rank whitePieceRank = Rank.createWhitePieceRank();
    Rank blankRank = Rank.createBlankRank();

    @Test
    @DisplayName("Rank의 각 piece의 표현 문자가 잘 나오는지 확인한다.")
    void getPrint() {
        assertEquals("PPPPPPPP", blackPawnRank.getPrint());
        assertEquals("RNBQKBNR", blackPieceRank.getPrint());
        assertEquals("pppppppp", whitePawnRank.getPrint());
        assertEquals("rnbqkbnr", whitePieceRank.getPrint());
        assertEquals("........", blankRank.getPrint());
    }

    @Test
    @DisplayName("Rank가 존재하는 piece의 개수를 잘 세는지 확인한다.")
    void getPieceCount() {
        assertEquals(8, blackPawnRank.getPieceCount(Pawn.createBlack()));
        assertEquals(2, blackPieceRank.getPieceCount(Knight.createBlack()));
        assertEquals(0, whitePawnRank.getPieceCount(Rook.createWhite()));
        assertEquals(1, whitePieceRank.getPieceCount(King.createWhite()));
        assertEquals(0, blankRank.getPieceCount(Queen.createWhite()));
    }

    @Test
    @DisplayName("Pawn의 column 위치를 잘 나타내는지 확인한다.")
    void getPawnPosition() {
        int[] result = blackPawnRank.getPawnPosition(Color.BLACK).toArray();
        int[] actual = {0, 1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(actual, result);
    }

}
