package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

public class Board {
    static Piece[][] pieces;
    private int sizeNum;

    public Board() {
        this.pieces = new Piece[8][8];
        this.sizeNum = 0;
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            this.pieces[1][i] = new Piece(Piece.BLACK);
            this.pieces[6][i] = new Piece(Piece.WHITE);
        }
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.pieces.length; i++) {
            stringBuilder.append(getLineResult(i));
        }
        appendNewLine(stringBuilder);
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

    public int size() {
        return this.sizeNum;
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
