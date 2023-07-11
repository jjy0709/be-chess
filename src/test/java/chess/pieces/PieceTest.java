package chess.pieces;

import chess.Position;
import chess.pieces.Piece.Type;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
//    @Test
//    @DisplayName("create piece with colors")
//    public void create_piece() {
//        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
//        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
//        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
//        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
//        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
//        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);
//
//        Piece blank = Piece.createBlank();
//        assertFalse(blank.isWhite());
//        assertFalse(blank.isBlack());
//        assertEquals(Type.NO_PIECE, blank.getType());
//    }

//    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
//        assertTrue(whitePiece.isWhite());
//        assertEquals(type, whitePiece.getType());
//
//        assertTrue(blackPiece.isBlack());
//        assertEquals(type, blackPiece.getType());
//    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
    }

//    @Test
//    public void checkPieceColor(){
//        Piece whitePawn = Piece.createWhitePawn();
//        assertSame(whitePawn.isWhite(), true);
//
//        Piece blackPawn = Piece.createBlackPawn();
//        assertSame(blackPawn.isBlack(), true);
//    }

//    @Test
//    public void checkKingQueenMove() {
//        Piece whiteKing = Piece.createWhiteKing();
//        assertEquals(false, whiteKing.verifyMovePiece(new Position("b2"), new Position("d3")));
//        assertEquals(true, whiteKing.verifyMovePiece(new Position("b2"), new Position("c3")));
//
//        Piece blackQueen = Piece.createBlackQueen();
//        assertEquals(false, blackQueen.verifyMovePiece(new Position("b2"), new Position("d3")));
//        assertEquals(true, blackQueen.verifyMovePiece(new Position("b2"), new Position("e5")));
//    }

//    @Test
//    @DisplayName("create pawn without color")
//    public void create_noColor() {
//        Piece piece = new Piece();
//        assertEquals(Piece.WHITE, piece.getColor());
//        assertEquals(Piece.WHITE_PRINT, piece.getPrint());
//    }
}