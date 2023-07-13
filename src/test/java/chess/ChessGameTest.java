package chess;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.pieces.Enums.Color.BLACK;
import static chess.pieces.Enums.Color.WHITE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ChessGame Test
 * - 게임 스코어 제대로 나오는지 확인
 *  - 킹이 없을 때
 *  - 킹이 있을 때
 * - 기물들 점수로 정렬했을 때 제대로 나오는지
 * - 보드 밖의 위치로 움직였을 때 에러 제대로 나오는지
 * - 킹 죽었을 때 exception 던지는지
 * - 움직이고 나서 게임 턴 돌아가는지
 */

class ChessGameTest {
    ChessGame chessGame = new ChessGame(new Board());

    @Test
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
    }

    private void addPiece(String position, Piece piece) {
        chessGame.movePiece(new Position(position), piece);
    }

    @Test
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
        assertEquals(0., resultBlack.get(0).getScore());
        assertEquals(5., resultWhite.get(0).getScore());
        // List contain 해서 첫번째 꺼의 점수랑 비 assertThat에 containsExactly로 순서 검증
    }
}
