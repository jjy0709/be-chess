package chess;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.pieces.Enums.Color.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
