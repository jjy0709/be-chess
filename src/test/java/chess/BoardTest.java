package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        board.initialize();
//        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.print()
        );
    }

    @Test
    public void verifyPieceCount() {
        board.initialize();
        assertEquals(board.getPieceCount(Piece.createBlackPawn()), 8);
        assertEquals(board.getPieceCount(Piece.createWhitePawn()), 8);
        assertEquals(board.getPieceCount(Piece.createBlackKnight()), 2);
        assertEquals(board.getPieceCount(Piece.createWhiteKnight()), 2);
        assertEquals(board.getPieceCount(Piece.createBlackBishop()), 2);
        assertEquals(board.getPieceCount(Piece.createWhiteBishop()), 2);
        assertEquals(board.getPieceCount(Piece.createBlackRook()), 2);
        assertEquals(board.getPieceCount(Piece.createWhiteRook()), 2);
        assertEquals(board.getPieceCount(Piece.createBlackQueen()), 1);
        assertEquals(board.getPieceCount(Piece.createWhiteQueen()), 1);
        assertEquals(board.getPieceCount(Piece.createBlackKing()), 1);
        assertEquals(board.getPieceCount(Piece.createWhiteKing()), 1);

        assertEquals(board.getPieceCount(Piece.createBlank()), 32);
    }

//    @Test
//    public void printBoard() {
//        String board_res = board.print();
//        System.out.println(board_res);
//    }
//    @Test
//    @DisplayName("create board and add pawn")
//    public void create() throws Exception {
//        verifyAddPawn(Pawn.WHITE, 1);
//        verifyAddPawn(Pawn.BLACK, 2);
//    }

//    public void verifyAddPawn(String color, int order) throws Exception {
//        Pawn pawn = new Pawn(color);
////        board.add(pawn);
//        assertEquals(order, board.size());
//        assertEquals(pawn, board.findPawn(order-1));
//    }

//    @Test
//    @DisplayName("add other object to board")
//    public void create_other() throws Exception {
//        assertThatThrownBy(() -> {
//            board.add(new Integer(7));
//        }).isInstanceOf(InputMismatchException.class)
//                .hasMessage("Not Pawn");
//    }

//    @Test
//    @DisplayName("find Pawn not exist")
//    public void find_err() throws Exception {
//        assertThatThrownBy(() -> {
//            board.findPawn(1);
//        }).isInstanceOf(RuntimeException.class)
//                .hasMessage("Invalid Index");
//    }
}