package chess;

import chess.pieces.Piece;

import java.util.*;
import java.util.stream.Stream;

public class Board {
    private List<Rank> ranks = new ArrayList<Rank>();
    public Board() {
        ;
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

    public Stream<Rank> getRank() {
        return this.ranks.stream();
    }

    public int getPieceCount(Piece p) {
        return this.ranks.stream().mapToInt(r -> r.getPieceCount(p)).sum();
    }

    public Piece getPieceAt(String loc) {
        Position pos = new Position(loc);
        return this.ranks.get(pos.rank).getPieceAt(pos.colum);
    }

    public void move(String loc, Piece piece) {
        Position dst = new Position(loc);
        this.ranks.get(dst.rank).move(dst.colum, piece);
    }

    public void move(String src, String des) throws Exception {
        Position pSrc = new Position(src);
        Position pDes = new Position(des);
        Piece piece = getPieceAt(src);
        if(!pDes.inBoard()) throw new Exception("Destination out of the board!");
        if(piece.getColor() == getPieceAt(des).getColor()) throw new Exception("You cannot move your piece to already existing location");
        if(!piece.verifyMovePiece(pSrc, pDes)) throw new Exception(String.format("You cannot move %s in that location", piece.getType()));
        move(des, getPieceAt(src));
        move(src, Piece.createBlank());
    }

}
