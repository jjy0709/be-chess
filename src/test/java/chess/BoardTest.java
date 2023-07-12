package chess;

import chess.Board.Board;
import chess.Board.Position;
import chess.pieces.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void verifyPieceCount() {
        board.initialize();
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
//
        assertEquals(32, board.getPieceCount(Blank.createBlank()));
    }

    @Test
    public void referPieceByLocation() {
        board.initialize();

        assertEquals(Rook.createBlack(), board.getPieceAt(new Position("h8")));
        assertEquals(Rook.createBlack(), board.getPieceAt(new Position("a8")));
        assertEquals(Rook.createWhite(), board.getPieceAt(new Position("a1")));
        assertEquals(Rook.createWhite(), board.getPieceAt(new Position("h1")));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        Position position = new Position("b5");
        Piece piece = Rook.createBlack();
        board.movePiece(position, piece);

        assertEquals(piece, board.getPieceAt(position));
    }

    @Test
    public void moveTest() throws Exception {
        board.initialize();

        Position sourcePosition = new Position("b2");
        Position targetPosition = new Position("b3");
        board.move(sourcePosition, targetPosition);
        assertEquals(Blank.createBlank(), board.getPieceAt(sourcePosition));
        assertEquals(Pawn.createWhite(), board.getPieceAt(targetPosition));
    }

    @Test
    public void moveKingQueen() throws Exception {
        board.initialize();

        //move king
        assertThrows(Exception.class, () -> {
            board.move(new Position("e1"), new Position("e2"));         // 이미 white 기물이 있는 위치
        });
        assertThrows(Exception.class, () -> {
            board.move(new Position("e1"), new Position("e3"));         // 킹이 움직일 수 없는 위치
        });
        assertThrows(Exception.class, () -> {
            board.move(new Position("e1"), new Position("e0"));         // 체스판 바깥의 위치
        });

        assertThrows(Exception.class, () -> {
            board.move(new Position("d1"), new Position("e2"));         // 이미 white 기물이 있는 위치
        });
        assertThrows(Exception.class, () -> {
            board.move(new Position("d1"), new Position("e4"));         // 킹이 움직일 수 없는 위치
        });
        assertThrows(Exception.class, () -> {
            board.move(new Position("d1"), new Position("e0"));         // 체스판 바깥의 위치
        });
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