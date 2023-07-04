package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

public class Board {
    static Piece[][] pieces;
    private int pieceCnt;

    public Board() {
        this.pieces = new Piece[8][8];
        this.pieceCnt = 0;
    }

    public void initialize() {
        addBlackPieces();
        for (int i = 0; i < 8; i++) {
            this.pieces[1][i] = Piece.createBlackPawn();
            this.pieces[6][i] = Piece.createWhitePawn();
            this.pieceCnt += 2;
        }
        addWhitePieces();
    }

    private void addWhitePieces() {
        this.pieces[7][0] = Piece.createWhiteRook();
        this.pieces[7][1] = Piece.createWhiteKnight();
        this.pieces[7][2] = Piece.createWhiteBishop();
        this.pieces[7][3] = Piece.createWhiteQueen();
        this.pieces[7][4] = Piece.createWhiteKing();
        this.pieces[7][5] = Piece.createWhiteBishop();
        this.pieces[7][6] = Piece.createWhiteKnight();
        this.pieces[7][7] = Piece.createWhiteRook();
        this.pieceCnt += 8;
    }

    private void addBlackPieces() {
        this.pieces[0][0] = Piece.createBlackRook();
        this.pieces[0][1] = Piece.createBlackKnight();
        this.pieces[0][2] = Piece.createBlackBishop();
        this.pieces[0][3] = Piece.createBlackQueen();
        this.pieces[0][4] = Piece.createBlackKing();
        this.pieces[0][5] = Piece.createBlackBishop();
        this.pieces[0][6] = Piece.createBlackKnight();
        this.pieces[0][7] = Piece.createBlackRook();
        this.pieceCnt += 8;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.pieces.length; i++) {
            stringBuilder.append(getLineResult(i));
            stringBuilder.append(appendNewLine(""));
        }
        return stringBuilder.toString();
    }

    public String getWhitePawnsResult() {
        return getLineResult(6);
    }

    public String getBlackPawnsResult() {
        return getLineResult(1);
    }

    private String getLineResult(int line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece p : this.pieces[line]) {
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
