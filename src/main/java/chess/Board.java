package chess;

import chess.pieces.Piece;

import java.util.ArrayList;

import static utils.StringUtils.appendNewLine;

public class Board {
    static ArrayList<Rank> ranks;
//    private int pieceCnt;

    public Board() {
        this.ranks = new ArrayList<Rank>();
//        this.pieceCnt = 0;
    }

    public void initialize() {
        this.ranks.add(Rank.createBlackPieceRank());
        this.ranks.add(Rank.createBlackPawnRank());
        for(int i=0;i<4;i++) this.ranks.add(Rank.createBlankRank());
        this.ranks.add(Rank.createWhitePawnRank());
        this.ranks.add(Rank.createWhitePieceRank());
    }

    public void initializeEmpty() {
        for(int i=0;i<8;i++) this.ranks.add(Rank.createBlankRank());
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
        for (Rank r: this.ranks) {
            stringBuilder.append(r.getPrint());
            stringBuilder.append(appendNewLine(""));
        }
        return stringBuilder.toString();
    }

    public String getWhitePawnsResult() {
        return this.ranks.get(6).getPrint();
    }

    public String getBlackPawnsResult() {
        return this.ranks.get(1).getPrint();
    }

    public int getPieceCount(Piece p) {
        int res = 0;
        for(Rank r: this.ranks){
            res += r.getPieceCount(p);
        }
        return res;
    }

    public Piece getPieceAt(String loc) {
        Position pos = new Position(loc);
        return this.ranks.get(pos.rank).getPieceAt(pos.colum);
    }

    public void move(String loc, Piece piece) {
        Position pos = new Position(loc);
        this.ranks.get(pos.rank).move(pos.colum, piece);
    }

    public double calculateScore(Piece.Color color) {
        if(!checkKingAlive(color)) return 0.;

        double res = 0.;

        for(Rank rank: this.ranks){
            res += rank.calculateScore(color);
        }

        double pawnRep = this.checkMultiPawn(color);

        return res - pawnRep;
    }

    private boolean checkKingAlive(Piece.Color color) {
        for(Rank rank: this.ranks){
            if(rank.checkKingAlive(color)) return true;
        }
        return false;
    }

    public double checkMultiPawn(Piece.Color color) {
        int[] pawnCnt = new int[8];

        for(Rank rank: this.ranks){
            ArrayList<Integer> list = rank.getPawnPosition(color);
            for(int i:list) pawnCnt[i] += 1;
        }

        double res = 0.;
        for(int cnt: pawnCnt){
            if(cnt <= 1) continue;
            res += cnt * 0.5;
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
