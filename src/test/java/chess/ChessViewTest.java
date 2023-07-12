package chess;

import org.junit.jupiter.api.Test;

import static utils.StringUtils.appendNewLine;

class ChessViewTest {
    ChessGame chessGame = new ChessGame();
    ChessView chessView = new ChessView(chessGame);

    @Test
    public void seeChessViewOperates() {
        chessGame.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                chessView.showBoard()
        );
    }


}