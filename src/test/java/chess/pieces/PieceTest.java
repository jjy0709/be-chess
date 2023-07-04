package chess.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("create pawn with colors")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_PRINT);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_PRINT);

        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, Piece.WHITE_PRINT);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK, Piece.BLACK_PRINT);

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Piece.WHITE_PRINT);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK, Piece.BLACK_PRINT);

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Piece.WHITE_PRINT);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Piece.BLACK_PRINT);

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Piece.WHITE_PRINT);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Piece.BLACK_PRINT);

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Piece.WHITE_PRINT);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK, Piece.BLACK_PRINT);
    }

    public static void verifyPiece(Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getPrint());
    }

//    @Test
//    @DisplayName("create pawn without color")
//    public void create_noColor() {
//        Piece piece = new Piece();
//        assertEquals(Piece.WHITE, piece.getColor());
//        assertEquals(Piece.WHITE_PRINT, piece.getPrint());
//    }
}