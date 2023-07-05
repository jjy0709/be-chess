package chess;

import chess.pieces.Piece;

import java.util.ArrayList;

import static utils.StringUtils.appendNewLine;

public class Board {
    static ArrayList<Rank> pieces;
//    private int pieceCnt;

    public Board() {
        this.pieces = new ArrayList<Rank>();
//        this.pieceCnt = 0;
    }

    public void initialize() {
        this.pieces.add(Rank.createBlackPieceRank());
        this.pieces.add(Rank.createBlackPawnRank());
        for(int i=0;i<4;i++) this.pieces.add(Rank.createBlankRank());
        this.pieces.add(Rank.createWhitePawnRank());
        this.pieces.add(Rank.createWhitePieceRank());
    }

//    private void addBlackPawns() {
//        ArrayList blackPawns = new ArrayList();
//        for(int i=0;i<8;i++) blackPawns.add(Piece.createBlackPawn());
//        this.pieces.add(blackPawns);
//        this.pieceCnt += 8;
//    }
//
//    private void addWhitePawns() {
//        ArrayList whitePawns = new ArrayList();
//        for(int i=0;i<8;i++) whitePawns.add(Piece.createWhitePawn());
//        this.pieces.add(whitePawns);
//        this.pieceCnt += 8;
//    }
//
//    private void addBlackPieces() {
//        ArrayList blackPieces = new ArrayList();
//        blackPieces.add(Piece.createBlackRook());
//        blackPieces.add(Piece.createBlackKnight());
//        blackPieces.add(Piece.createBlackBishop());
//        blackPieces.add(Piece.createBlackQueen());
//        blackPieces.add(Piece.createBlackKing());
//        blackPieces.add(Piece.createBlackBishop());
//        blackPieces.add(Piece.createBlackKnight());
//        blackPieces.add(Piece.createBlackRook());
//        this.pieces.add(blackPieces);
//        this.pieceCnt += 8;
//    }
//    private void addWhitePieces() {
//        ArrayList whitePieces = new ArrayList();
//        whitePieces.add(Piece.createWhiteRook());
//        whitePieces.add(Piece.createWhiteKnight());
//        whitePieces.add(Piece.createWhiteBishop());
//        whitePieces.add(Piece.createWhiteQueen());
//        whitePieces.add(Piece.createWhiteKing());
//        whitePieces.add(Piece.createWhiteBishop());
//        whitePieces.add(Piece.createWhiteKnight());
//        whitePieces.add(Piece.createWhiteRook());
//        this.pieces.add(whitePieces);
//        this.pieceCnt += 8;
//    }
//
//    private void addBlankPieces() {
//        ArrayList<Piece> blankPieces = new ArrayList();
//        for(int i=0;i<8;i++) blankPieces.add(Piece.createBlank());
//        this.pieces.add(blankPieces);
//        this.pieceCnt += 8;
//    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rank r: this.pieces) {
            stringBuilder.append(r.getPrint());
            stringBuilder.append(appendNewLine(""));
        }
        return stringBuilder.toString();
    }

    public String getWhitePawnsResult() {
        return this.pieces.get(6).getPrint();
    }

    public String getBlackPawnsResult() {
        return this.pieces.get(1).getPrint();
    }

    public int getPieceCount(Piece p) {
        int res = 0;
        for(Rank r: this.pieces){
            res += r.getPieceCount(p);
        }
        return res;
    }


//    public int pieceCount() {
//        return this.pieceCnt;
//    }

//    public Pawn findPawn(int index) {
//        if(index < this.size())
//            return this.pieces.get(index);
//        else
//            throw new RuntimeException("Invalid Index");
//    }

//    public <T> void add(T p) throws Exception {
//        if(p instanceof Pawn)
//            this.pieces.add((Pawn) p);
//        else
//            throw new InputMismatchException("Not Pawn");
//    }
}
