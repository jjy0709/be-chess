package chess;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    public void initial() {
        board = new Board();
        board.initialize();
    }

    @Test
    public void initialize() throws Exception {
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    @Test
    public void printBoard() {
        String board_res = board.print();
        System.out.println(board_res);
    }
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