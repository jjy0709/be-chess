package chess;

import chess.pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chess.Position.distance;
import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> ranks = new ArrayList<Rank>();

    public Board() { }

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
        Position pos = new Position(loc);
        this.ranks.get(pos.rank).move(pos.colum, piece);
    }

    public void move(String src, String des) {
        move(des, getPieceAt(src));
        move(src, Piece.createBlank());
    }

    public void moveKing(String src, String des) throws Exception {
        Position pSrc = new Position(src);
        Position pDes = new Position(des);
        if(!pDes.inBoard()) throw new Exception("Destination out of the board!");
        if(distance(pSrc,pDes) != 1) throw new Exception("You cannot move king over one block!");
        if(getPieceAt(src).getColor() == getPieceAt(des).getColor()) throw new Exception("You cannot move your piece to already existing location");
        move(src, des);
    }


    private boolean checkMovePossible(String loc, Piece piece) {
        Piece piece1 = getPieceAt(loc);
        if(piece1.getColor() == piece.getColor()) return false;

    }

}
