package chess.board;

import chess.pieces.*;
import chess.pieces.Enums.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

        board.movePiece(new Position("c3"), Pawn.createWhite());
        board.movePiece(new Position("c6"), Pawn.createBlack());
        int[] actual2 = {1,1,2,1,1,1,1,1};
        assertArrayEquals(actual2, board.getPawnCountOfEachColumn(color));

        board.movePiece(new Position("f3"), Pawn.createWhite());
        board.movePiece(new Position("f6"), Pawn.createBlack());
        int[] actual3 = {1,1,2,1,1,2,1,1};
        assertArrayEquals(actual3, board.getPawnCountOfEachColumn(color));
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
        Position whiteSource = new Position("b2");
        Position whiteDestination = new Position("b3");
        Position blackSource = new Position("e7");
        Position blackDestination = new Position("e5");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(whiteSource, whiteDestination, BLACK);
        });
        assertDoesNotThrow(() -> {
            board.move(whiteSource, whiteDestination, WHITE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            board.move(blackSource, blackDestination, WHITE);
        });
        assertDoesNotThrow(() -> {
            board.move(blackSource, blackDestination, BLACK);
        });
    }

    @Test
    @DisplayName("같은 색의 기물이 있는 위치에 기물을 이동시킬 수 없다.")
    void moveSameColorPiecePosition() {
        Position rookSource = new Position("a1");
        Position rookDestination = new Position("a2");
        Position knightSource = new Position("g8");
        Position knightDestination = new Position("e7");
        Position knightPossiblePosition = new Position("h6");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(rookSource, rookDestination, WHITE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            board.move(knightSource, knightDestination, BLACK);
        });
        assertDoesNotThrow(() -> {
            board.move(knightSource, knightPossiblePosition, BLACK);
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
    @DisplayName("나이트를 제외한 기물은 다른 기물을 넘어 이동할 수 없다.")
    void moveOverOtherPiece() {
        Position rookPosition = new Position("a1");
        Position rookMoveTo = new Position("a3");

        Position queenPosition = new Position("e8");
        Position queenMoveTo = new Position("b5");

        Position knightPosition = new Position("g1");
        Position knightMoveTo = new Position("f3");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(rookPosition, rookMoveTo, WHITE);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(queenPosition, queenMoveTo, BLACK);
        });

        assertDoesNotThrow(() -> {
            board.move(knightPosition, knightMoveTo, WHITE);
        });
    }

}
