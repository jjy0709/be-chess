package chess;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.StringUtils.appendNewLine;

public class ChessView {
    private Board board;

    public ChessView(Board board){
        this.board = board;
    }

    public String view() {
        return board.getRank().map(Rank::getPrint).map(p -> appendNewLine(p)).collect(Collectors.joining());
    }
}
