package chess;

import chess.pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public String print() {
        return this.ranks.stream().map(Rank::getPrint).map(p -> appendNewLine(p)).collect(Collectors.joining());
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

    public double calculateScore(Piece.Color color) {
        if(!checkKingAlive(color)) return 0.;

//        double pawnRep = this.checkMultiPawn(color);

        return this.ranks.stream().mapToDouble(r -> r.calculateScore(color)).sum() - this.checkMultiPawn(color);
    }

    private boolean checkKingAlive(Piece.Color color) {
        return this.ranks.stream().anyMatch(r -> r.checkKingAlive(color));
    }

    public double checkMultiPawn(Piece.Color color) {
//        Map<Integer, Long> pawnCnt = this.ranks.stream()
//                .flatMapToInt(r->r.getPawnPosition(color))
//                 .boxed()
//                 .collect(Collectors.groupingBy(arg -> arg, HashMap::new, Collectors.counting()));

        return this.ranks.stream()
                .flatMapToInt(r->r.getPawnPosition(color))
                .boxed()
                .collect(Collectors.groupingBy(arg -> arg, HashMap::new, Collectors.counting()))
                .values().stream()
                .filter(p -> p >= 2)
                .mapToDouble(p -> p*0.5)
                .sum();
    }

    public List<Piece> sortPiecesByScore(Piece.Color color, boolean asend) {
        Comparator cmp = asend?Comparator.comparing(Piece::getScore):Comparator.comparing(Piece::getScore).reversed();

        return this.ranks.stream()
                .flatMap(r -> r.getPieceOfColor(color))
                .sorted(cmp).toList();
    }

    public void move(String src, String des) {
        move(des, getPieceAt(src));
        move(src, Piece.createBlank());
    }

}
