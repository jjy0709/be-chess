package chess.pieces;

import chess.ChessGame;
import chess.board.Board;
import chess.board.Position;
import chess.pieces.Enums.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    Pawn white = Pawn.createWhite();
    Pawn black = Pawn.createBlack();
    ChessGame chessGame = new ChessGame(new Board());

    @Test
    @DisplayName("폰을 생성하여 타입, 색, 표현 문자를 테스트한다.")
    void createPiece() {
        assertTrue(white.isWhite());
        assertTrue(black.isBlack());

        assertEquals(Type.PAWN, white.getType());
        assertEquals(Type.PAWN, black.getType());

        assertEquals('p', white.getRepresentation());
        assertEquals('P', black.getRepresentation());
    }

    @Test
    @DisplayName("폰은 처음에 한 칸이나 두 칸을 움직일 수 있다.")
    void checkVerifyPositionNotMoved() {
        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("c2"), new Position("c4")));
        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("e7"), new Position("e6")));
    }

//    @Test
//    @DisplayName("이미 움직인 폰은 한 칸만 움직일 수 있다.")
//    void checkVerifyPositionMoved() {
//        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("c2"), new Position("c4")));
//        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("e7"), new Position("e6")));
//        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("c4"), new Position("c6")));
//        assertDoesNotThrow(() -> white.verifyMovePosition(new Position("c4"), new Position("c5")));
//        assertThrows(Exception.class, () -> black.verifyMovePosition(new Position("e6"), new Position("e4")));
//        assertDoesNotThrow(() -> black.verifyMovePosition(new Position("e6"), new Position("e5")));
//    }

    @Test
    @DisplayName("대각선에 적이 없는 경우 폰은 앞으로만 움직일 수 있다.")
    void checkVerifyPositionDiagonalNoEnemy() {
        chessGame.initializeEmpty();
        chessGame.movePiece(new Position("c2"), white);
        assertThrows(Exception.class, () -> white.verifyMovePosition(new Position("c2"), new Position("d3")));

    }

    @Test
    @DisplayName("대각선에 적이 있는 경우 대각선으로 한 칸 움직일 수 있다.")
    void checkVerifyPositionDiagonalEnemy() {
        chessGame.initializeEmpty();
        chessGame.movePiece(new Position("c2"), white);
        chessGame.movePiece(new Position("d3"), black);
        assertDoesNotThrow(() -> white.verifyMovePositionWhenEnemyExist(new Position("c2"), new Position("d3")));
    }

}