package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

class MainTest {
    /**
     * Main Test 할 것
     * start 없이 다른 명령어 들어왔을 때
     * move 뒤에 다른게 붙어 들어왔을 때
     * move 뒤에 인자 2개 넘게 들어왔을 때
     * move 뒤에 이상한 위치가 들어왔을 때 ex) a12 zfe 등등
     */

    Main mainObject;

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    InputStream inputStream;

    @BeforeEach
    void setup() {
        mainObject = new Main();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("start 입력 없이 다른 input이 입력되면 게임이 시작되지 않았음을 알려준다.")
    void wrongInputBeforeStart() {
        String input = appendNewLine("move a2 a3");
        String inputWithEnd = appendNewLine(input.concat("end"));

        inputStream = new ByteArrayInputStream(inputWithEnd.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(
                appendNewLine("명령어를 입력하세요.") +
                appendNewLine("게임이 시작되지 않았습니다.") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("게임을 종료합니다.")
                , byteArrayOutputStream.toString());
    }

    @Test
    @DisplayName("move 뒤에 다른 명령어가 붙어 들어왔을 때 다시 명령어를 입력받는다.")
    void wrongInputAfterMove() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appendNewLine("start"));
        stringBuilder.append(appendNewLine("movestart a2 a3"));
        stringBuilder.append(appendNewLine("end"));

        inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("잘못된 입력입니다.") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("게임을 종료합니다.")
                , byteArrayOutputStream.toString());
    }

    @Test
    @DisplayName("move 뒤에 인자가 2개가 들어오지 않았을 때 다시 명령어를 입력받는다.")
    void wrongInputPositionNumberWrong() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appendNewLine("start"));
        stringBuilder.append(appendNewLine("move a2 a3 a4"));
        stringBuilder.append(appendNewLine("end"));

        inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("잘못된 입력입니다.") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("게임을 종료합니다.")
                , byteArrayOutputStream.toString());
    }

    @Test
    @DisplayName("move 뒤에 이상한 위치가 들어왔을 때 다시 명령어를 입력받는다.")
    void wrongPositionAfterMoveInput() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appendNewLine("start"));
        stringBuilder.append(appendNewLine("move a23 a31"));
        stringBuilder.append(appendNewLine("end"));

        inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("유효하지 않은 위치입니다.") +
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr") +
                        appendNewLine("명령어를 입력하세요.") +
                        appendNewLine("게임을 종료합니다.")
                , byteArrayOutputStream.toString());
    }

}
