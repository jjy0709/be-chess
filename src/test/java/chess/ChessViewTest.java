package chess;

import chess.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

class ChessViewTest {
    ChessGame chessGame = new ChessGame(new Board());
    ChessView chessView = new ChessView();

    PrintStream printStream = System.out;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void seeChessViewOperates() {
        chessGame.initialize();
        chessView.showGameBoard(chessGame);

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                byteArrayOutputStream.toString()
        );
    }


}
