package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("create board and add pawn")
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("add other object to board")
    public void create_other() throws Exception {
        Board board = new Board();
        assertThatThrownBy(() -> {
            board.add(new Integer("7"));
        }).isInstanceOf(InputMismatchException.class)
                .hasMessage("Not Pawn");
    }
}