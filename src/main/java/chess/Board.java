package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static utils.StringUtils.appendNewLine;

public class Board {
    static ArrayList<Rank> ranks;

    public Board() {
        this.ranks = new ArrayList<Rank>();
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

    public ArrayList<Piece> sortPiecesByScore(Piece.Color color, boolean asend) {
        ArrayList<Piece> res = new ArrayList<>();

        for(Rank rank: this.ranks){
            ArrayList<Piece> list = rank.getPieceOfColor(color);
            res.addAll(list);
        }

        res.sort((Piece p1, Piece p2) -> (int)Math.floor(p1.getScore() - p2.getScore()));
        if(!asend) Collections.reverse(res);

        return res;
    }

    public void move(String src, String des) {
//        Position pos_src = new Position(src);
//        Position pos_des = new Position(des);
        move(des, getPieceAt(src));
        move(src, Piece.createBlank());
    }

}
