package chess.board;

import chess.pieces.*;
import chess.pieces.Enums.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.lang.reflect.Method;

import static chess.pieces.Enums.Color.BLACK;
import static chess.pieces.Enums.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("보드 초기화가 잘 작동하는지 확인한다.")
    void verifyPieceCount() {
        assertEquals(board.getPieceCount(Pawn.createBlack()), 8);
        assertEquals(board.getPieceCount(Pawn.createWhite()), 8);
        assertEquals(board.getPieceCount(Knight.createBlack()), 2);
        assertEquals(board.getPieceCount(Knight.createWhite()), 2);
        assertEquals(board.getPieceCount(Bishop.createBlack()), 2);
        assertEquals(board.getPieceCount(Bishop.createWhite()), 2);
        assertEquals(board.getPieceCount(Rook.createBlack()), 2);
        assertEquals(board.getPieceCount(Rook.createWhite()), 2);
        assertEquals(board.getPieceCount(Queen.createBlack()), 1);
        assertEquals(board.getPieceCount(Queen.createWhite()), 1);
        assertEquals(board.getPieceCount(King.createBlack()), 1);
        assertEquals(board.getPieceCount(King.createWhite()), 1);

        assertEquals(32, board.getPieceCount(Blank.createBlank()));
    }

    @Test
    @DisplayName("Position을 통해 Piece에 접근하는 것이 잘 작동하는지 확인한다.")
    void referPieceByLocation() {
        assertEquals(Rook.createBlack(), board.getPieceAt(new Position("h8")));
        assertEquals(Rook.createBlack(), board.getPieceAt(new Position("a8")));
        assertEquals(Rook.createWhite(), board.getPieceAt(new Position("a1")));
        assertEquals(Rook.createWhite(), board.getPieceAt(new Position("h1")));
    }

    @ParameterizedTest
    @EnumSource(value = Color.class, names = {"WHITE", "BLACK"})
    @DisplayName("특정 색의 기물들의 리스트를 잘 받아오는지 확인한다.")
    void getPieceListByColor(Color color) {
        assertEquals(16, board.getPieceListOfColor(color).size());
    }

    @ParameterizedTest
    @EnumSource(value = Color.class, names = {"WHITE", "BLACK"})
    @DisplayName("특정 색의 폰들의 컬럼 위치를 잘 받아오는지 확인한다.")
    void getPawnCountOfEachColumn(Color color) {
        int[] actual = {1,1,1,1,1,1,1,1};
        assertArrayEquals(actual, board.getPawnCountOfEachColumn(color));
    }

    @Test
    @DisplayName("게임의 턴에 맞지 않는 말을 움직일 수 없다.")
    void verifyGameTurnCorrect() throws NoSuchMethodException {
        Class<Board> clazz = Board.class;
        Method checkGameTurnCorrect = clazz.getDeclaredMethod("checkGameTurnCorrect", Piece.class, Color.class);
        checkGameTurnCorrect.setAccessible(true);

        assertThrows(IllegalArgumentException.class, ()
                -> checkGameTurnCorrect.invoke(Pawn.createWhite(), BLACK));
        assertThrowsExactly(IllegalArgumentException.class, ()
                        -> checkGameTurnCorrect.invoke(Pawn.createBlack(), WHITE),
                String.format("%s의 차례입니다.", WHITE.toString()));
    }


    /**
     * Board의 move 테스트
     * - 빈 칸을 움직이려고 할 때
     * - 게임 턴이 안 맞을 때
     * - 같은 색의 기물이 있는 위치로 움직이려 할 때
     * - 폰은 처음에만 두 칸 움직일 수 있다
     * - 다른 기물을 넘을 수 없다.
     **/
    @Test
    @DisplayName("빈 칸을 움직이는 것은 불가능하다.")
    void moveBlank() {
        Position source = new Position("c3");
        Position destination = new Position("d3");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(source, destination, WHITE);
        });
    }

    @Test
    @DisplayName("다른 색의 차례일 경우 자신의 말을 움직일 수 없다.")
    void moveAtNotRightTurn() {
        Position source = new Position("b2");
        Position destination = new Position("b3");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(source, destination, BLACK);
        });
    }

    @Test
    @DisplayName("같은 색의 기물이 있는 위치에 기물을 이동시킬 수 없다.")
    void moveSameColorPiecePosition() {
        Position source = new Position("a1");
        Position destination = new Position("a2");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(source, destination, WHITE);
        });
    }

    @Test
    @DisplayName("폰은 첫 움직임에만 두 칸을 이동할 수 있다.")
    void movePawnTwice() {
        Position pawnPosition = new Position("a2");
        Position firstMove = new Position("a4");
        Position secondMove = new Position("a6");
        Position thirdMove = new Position("a5");

        assertDoesNotThrow(() -> {
            board.move(pawnPosition, firstMove, WHITE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            board.move(firstMove, secondMove, WHITE);
        });
        assertDoesNotThrow(() -> {
            board.move(firstMove, thirdMove, WHITE);
        });

    }

    @Test
    @DisplayName("한 기물은 다른 기물을 넘어 이동할 수 없다.")
    void moveOverOtherPiece() {
        Position rookPosition = new Position("a1");
        Position moveTo = new Position("a3");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(rookPosition, moveTo, WHITE);
        });
    }

}
