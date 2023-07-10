package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

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
//
        assertEquals(32, board.getPieceCount(Piece.createBlank()));
    }

    @Test
    public void referPieceByLocation() {
        board.initialize();

        assertEquals(Piece.createBlackRook(), board.getPieceAt("a8"));
        assertEquals(Piece.createBlackRook(), board.getPieceAt("h8"));
        assertEquals(Piece.createWhiteRook(), board.getPieceAt("a1"));
        assertEquals(Piece.createWhiteRook(), board.getPieceAt("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.getPieceAt(position));
        System.out.println(board.print());
    }

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

        assertEquals(15.0, board.calculateScore(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, board.calculateScore(Piece.Color.WHITE), 0.01);

        System.out.println(board.print());
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

        List<Piece> res = board.sortPiecesByScore(Piece.Color.BLACK, true);
        for(Piece piece:res) System.out.println(piece.getScore());
    }

    @Test
    public void moveTest() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        assertEquals(Piece.createBlank(), board.getPieceAt(sourcePosition));
        assertEquals(Piece.createWhitePawn(), board.getPieceAt(targetPosition));
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