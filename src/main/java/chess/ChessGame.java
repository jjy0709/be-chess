package chess;

import chess.pieces.Piece;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ChessGame {
    Board board;

    public ChessGame(Board board){
        this.board = board;
    }

    public double calculateScore(Piece.Color color) {
        if(!checkKingAlive(color)) return 0.;

//        double pawnRep = this.checkMultiPawn(color);

        return this.board.getRank().mapToDouble(r -> r.calculateScore(color)).sum() - this.checkMultiPawn(color);
    }

    private boolean checkKingAlive(Piece.Color color) {
        return this.board.getRank().anyMatch(r -> r.checkKingAlive(color));
    }

    public double checkMultiPawn(Piece.Color color) {
//        Map<Integer, Long> pawnCnt = this.ranks.stream()
//                .flatMapToInt(r->r.getPawnPosition(color))
//                 .boxed()
//                 .collect(Collectors.groupingBy(arg -> arg, HashMap::new, Collectors.counting()));

        return this.board.getRank()
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

        return this.board.getRank()
                .flatMap(r -> r.getPieceOfColor(color))
                .sorted(cmp).toList();
    }
}
