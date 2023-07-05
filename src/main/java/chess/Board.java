package chess;

import chess.pieces.Piece;

import java.util.ArrayList;

import static utils.StringUtils.appendNewLine;

public class Board {
    static ArrayList<ArrayList<Piece>> pieces;
    private int pieceCnt;

    public Board() {
        this.pieces = new ArrayList<>();
        this.pieceCnt = 0;
    }

    public void initialize() {
        addBlackPieces();
        addBlackPawns();
        for(int i=0;i<4;i++) this.pieces.add(new ArrayList<>());
        addWhitePawns();
        addWhitePieces();
    }

    private void addBlackPawns() {
        ArrayList blackPawns = new ArrayList();
        for(int i=0;i<8;i++) blackPawns.add(Piece.createBlackPawn());
        this.pieces.add(blackPawns);
        this.pieceCnt += 8;
    }

    private void addWhitePawns() {
        ArrayList whitePawns = new ArrayList();
        for(int i=0;i<8;i++) whitePawns.add(Piece.createWhitePawn());
        this.pieces.add(whitePawns);
        this.pieceCnt += 8;
    }

    private void addBlackPieces() {
        ArrayList blackPieces = new ArrayList();
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
        this.pieces.add(blackPieces);
        this.pieceCnt += 8;
    }
    private void addWhitePieces() {
        ArrayList whitePieces = new ArrayList();
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
        this.pieces.add(whitePieces);
        this.pieceCnt += 8;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList pieceList: this.pieces) {
            stringBuilder.append(getLineResult(pieceList));
            stringBuilder.append(appendNewLine(""));
        }
        return stringBuilder.toString();
    }

    public String getWhitePawnsResult() {
        return getLineResult(this.pieces.get(6));
    }

    public String getBlackPawnsResult() {
        return getLineResult(this.pieces.get(1));
    }

    private String getLineResult(ArrayList<Piece> list) {
        if(list.size()==0) return "........";
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece p : list) {
            stringBuilder.append(p!=null?p.getPrint():'.');
        }
        return stringBuilder.toString();
    }

    public int pieceCount() {
        return this.pieceCnt;
    }

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
