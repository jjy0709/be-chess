package chess;

import chess.Board.Position;
import chess.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {
    private ChessGame chessGame = new ChessGame();

    @Test
    public void caculcatePoint() throws Exception {
        chessGame.initializeEmpty();

        addPiece("b6", Pawn.createBlack());
        addPiece("e6", Queen.createBlack());
        addPiece("b8", King.createBlack());
        addPiece("c8", Rook.createBlack());

        addPiece("f2", Pawn.createWhite());
        addPiece("g2", Pawn.createWhite());
        addPiece("e1", Rook.createWhite());
        addPiece("f1", King.createWhite());

        assertEquals(15.0, chessGame.getGameScoreOf(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, chessGame.getGameScoreOf(Piece.Color.WHITE), 0.01);
    }

    private void addPiece(String position, Piece piece) {
        board.movePiece(new Position(position), piece);
    }

    @Test
    public void sortPieceAscend() {
//        board.initialize();
        board.initializeEmpty();

        addPiece("b6", Pawn.createBlack());
        addPiece("e6", Queen.createBlack());
        addPiece("b8", King.createBlack());
        addPiece("c8", Rook.createBlack());

        addPiece("f2", Pawn.createWhite());
        addPiece("g2", Pawn.createWhite());
        addPiece("e1", Rook.createWhite());
        addPiece("f1", King.createWhite());

        List<Piece> res = chessGame.sortPiecesByScore(Piece.Color.BLACK, true);
        res.stream().map(p -> p.getScore()).forEach(System.out::println);
    }
}