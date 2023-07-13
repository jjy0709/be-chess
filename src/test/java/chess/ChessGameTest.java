package chess;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.pieces.Enums.Color.BLACK;
import static chess.pieces.Enums.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ChessGame Test
 * - 게임 스코어 제대로 나오는지 확인
 * - 킹이 없을 때
 * - 킹이 있을 때
 * - 기물들 점수로 정렬했을 때 제대로 나오는지
 * - 보드 밖의 위치로 움직였을 때 에러 제대로 나오는지
 * - 킹 죽었을 때 exception 던지는지
 * - 움직이고 나서 게임 턴 돌아가는지
 */

class ChessGameTest {
    ChessGame chessGame = new ChessGame(new Board());

    @Test
    @DisplayName("체스 게임의 점수를 계산했을 때 올바른 점수가 나와야 한다. (킹이 없을 경우 0점)")
    void calculatePoint() {
        chessGame.initializeEmpty();

        addPiece("b6", Pawn.createBlack());
        addPiece("e6", Queen.createBlack());
        addPiece("b8", King.createBlack());
        addPiece("c8", Rook.createBlack());

        addPiece("f2", Pawn.createWhite());
        addPiece("g2", Pawn.createWhite());
        addPiece("e1", Rook.createWhite());
        addPiece("f1", King.createWhite());

        assertEquals(15.0, chessGame.getGameScoreOf(BLACK), 0.01);
        assertEquals(7.0, chessGame.getGameScoreOf(WHITE), 0.01);

        addPiece("f1", Blank.createBlank());
        assertEquals(0.0, chessGame.getGameScoreOf(WHITE), 0.01);
    }

    private void addPiece(String position, Piece piece) {
        chessGame.movePiece(new Position(position), piece);
    }

    @Test
    @DisplayName("보드 위의 기물들을 점수에 따라 정렬했을 때 올바른 순서로 정렬되어야 한다.")
    void sortPieceAscend() {
        chessGame.initializeEmpty();

        addPiece("b6", Pawn.createBlack());
        addPiece("e6", Queen.createBlack());
        addPiece("b8", King.createBlack());
        addPiece("c8", Rook.createBlack());

        addPiece("f2", Pawn.createWhite());
        addPiece("g2", Pawn.createWhite());
        addPiece("e1", Rook.createWhite());
        addPiece("f1", King.createWhite());

        List<Piece> resultBlack = chessGame.sortPiecesByScore(BLACK, true);
        List<Piece> resultWhite = chessGame.sortPiecesByScore(WHITE, false);

        Piece[] actualBlack = new Piece[]{King.createBlack(), Pawn.createBlack(), Rook.createBlack(), Queen.createBlack()};
        Piece[] actualWhite = new Piece[]{Rook.createWhite(), Pawn.createWhite(), Pawn.createWhite(), King.createWhite()};

        assertArrayEquals(resultBlack.toArray(), actualBlack);
        assertArrayEquals(resultWhite.toArray(), actualWhite);
    }

    @Test
    @DisplayName("보드 밖의 위치에서 이동하거나 보드 밖으로 이동할 수 없다.")
    void moveWrongPosition() {
        chessGame.initialize();
        String outBoard = "a0";
        String outBoard1 = "a24";
        String outBoard2 = "wrong1";
        String outBoard3 = "z4";
        String inBoard = "a3";

        assertThrows(IllegalArgumentException.class, () -> {
            chessGame.move(outBoard1, inBoard);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            chessGame.move(outBoard1, outBoard2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            chessGame.move(inBoard, outBoard3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            chessGame.move(outBoard, inBoard);
        });

    }

    @Test
    @DisplayName("킹이 죽으면 게임이 끝나야 한다.")
    void checkGameEndsWhenKingDie() {
        chessGame.initialize();

        chessGame.move("e2", "e3");
        chessGame.move("d7", "d5");
        chessGame.move("f1", "b5");
        chessGame.move("e7", "e6");

        assertThrows(RuntimeException.class, () -> {
            chessGame.move("b5", "e8");
        });
    }

    @Test
    @DisplayName("한 사람이 움직이고 나면 다음 사람의 턴이 되어야 한다.")
    void checkGameTurns() {
        chessGame.initialize();

        try {
            chessGame.move("a2", "a2");
        } catch (Exception exception) {
            ;
        }
        assertThrows(IllegalArgumentException.class, () -> {
            chessGame.move("d7", "d5");
        });
        assertDoesNotThrow(() -> {
            chessGame.move("a2", "a3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            chessGame.move("e2", "e3");
        });
    }

}
