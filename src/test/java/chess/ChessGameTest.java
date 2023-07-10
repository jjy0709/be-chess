package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {
    private Board board = new Board();
    private ChessGame chessGame = new ChessGame(board);

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.0, chessGame.calculateScore(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, chessGame.calculateScore(Piece.Color.WHITE), 0.01);
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    public void sortPieceAscend() {
//        board.initialize();
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        List<Piece> res = chessGame.sortPiecesByScore(Piece.Color.BLACK, true);
        res.stream().map(p -> p.getScore()).forEach(System.out::println);
    }
}