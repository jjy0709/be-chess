package chess;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.StringUtils.appendNewLine;

public class ChessView {
    private Board board;

    public ChessView(Board board) {
        this.board = board;
    }

    // void로 하고 출력까지 하는 게 더 맞는 것 같다 / String 반환하면 테스트하기 편함
    public String view() {
        return board.getRank().map(Rank::getPrint).map(p -> appendNewLine(p)).collect(Collectors.joining());
    }
}
