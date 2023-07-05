package chess;

import chess.pieces.Piece;

import java.util.ArrayList;

public class Rank {
    private ArrayList<Piece> pieces;

    private Rank(){
        this.pieces = new ArrayList<Piece>();
    }

    public String getPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Piece p: this.pieces) stringBuilder.append(p.getPrint());
        return stringBuilder.toString();
    }

    public int getPieceCount(Piece p) {
        int res = 0;
        for(Piece piece: this.pieces){
            res += piece.equals(p)?1:0;
        }
        return res;
    }

    public Piece getPieceAt(int c) {
        return this.pieces.get(c);
    }

    public void move(int c, Piece piece) {
        this.pieces.set(c, piece);
    }

    public static Rank createBlackPawnRank() {
        Rank rank = new Rank();
        for(int i=0;i<8;i++) rank.pieces.add(Piece.createBlackPawn());
        return rank;
    }

    public static Rank createBlackPieceRank() {
        Rank rank = new Rank();
        rank.pieces.add(Piece.createBlackRook());
        rank.pieces.add(Piece.createBlackKnight());
        rank.pieces.add(Piece.createBlackBishop());
        rank.pieces.add(Piece.createBlackQueen());
        rank.pieces.add(Piece.createBlackKing());
        rank.pieces.add(Piece.createBlackBishop());
        rank.pieces.add(Piece.createBlackKnight());
        rank.pieces.add(Piece.createBlackRook());
        return rank;
    }

    public static Rank createWhitePawnRank() {
        Rank rank = new Rank();
        for(int i=0;i<8;i++) rank.pieces.add(Piece.createWhitePawn());
        return rank;
    }

    public static Rank createWhitePieceRank() {
        Rank rank = new Rank();
        rank.pieces.add(Piece.createWhiteRook());
        rank.pieces.add(Piece.createWhiteKnight());
        rank.pieces.add(Piece.createWhiteBishop());
        rank.pieces.add(Piece.createWhiteQueen());
        rank.pieces.add(Piece.createWhiteKing());
        rank.pieces.add(Piece.createWhiteBishop());
        rank.pieces.add(Piece.createWhiteKnight());
        rank.pieces.add(Piece.createWhiteRook());
        return rank;
    }

    public static Rank createBlankRank() {
        Rank rank = new Rank();
        for (int i=0;i<8;i++) rank.pieces.add(Piece.createBlank());
        return rank;
    }
}
