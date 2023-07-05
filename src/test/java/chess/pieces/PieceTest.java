package chess.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("create pawn with colors")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, 'P');

        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, 'n');
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, 'N');

        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, 'r');
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, 'R');

        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, 'b');
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, 'B');

        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, 'q');
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, 'Q');

        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, 'k');
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, 'K');
    }

    private void verifyPiece(Piece piece, Piece.Color color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getPrint());
    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
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