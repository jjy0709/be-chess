package chess.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("create pawn with colors")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, 'P');

        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, 'n');
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK, 'N');

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE, 'r');
        verifyPiece(Piece.createBlackRook(), Piece.BLACK, 'R');

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, 'b');
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK, 'B');

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, 'q');
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK, 'Q');

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE, 'k');
        verifyPiece(Piece.createBlackKing(), Piece.BLACK, 'K');
    }

    private void verifyPiece(Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getPrint());
    }

    @Test
    public void checkPieceColor(){
        Piece whitePawn = Piece.createWhitePawn();
        assertSame(whitePawn.isWhite(), true);

        Piece blackPawn = Piece.createBlackPawn();
        assertSame(blackPawn.isBlack(), true);
    }

//    @Test
//    @DisplayName("create pawn without color")
//    public void create_noColor() {
//        Piece piece = new Piece();
//        assertEquals(Piece.WHITE, piece.getColor());
//        assertEquals(Piece.WHITE_PRINT, piece.getPrint());
//    }
}