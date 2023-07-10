package chess;

import chess.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

class ChessViewTest {
    Board board = new Board();
    ChessView chessView = new ChessView(board);

    @Test
    public void seeChessViewOperates() {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                chessView.view()
        );
    }


}