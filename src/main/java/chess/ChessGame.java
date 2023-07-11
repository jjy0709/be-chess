package chess;

import chess.pieces.Piece;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessGame {
    Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    // gameInit 랑 다른 여러 함수 더 구현해야될듯..

    public double calculateScore(Piece.Color color) {
        if (!checkKingAlive(color)) return 0.;
        return calculatePointSum(color) + calculatePenaltyPoint(color);
    }

    private boolean checkKingAlive(Piece.Color color) {
        return this.board.getRank().anyMatch(r -> r.checkKingAlive(color));
    }

    private double calculatePointSum(Piece.Color color) {
        return this.board.getRank()
                .mapToDouble(r -> r.calculateScore(color))
                .sum();
    }

    private double calculatePenaltyPoint(Piece.Color color) {
        Map<Integer, Long> pawnCnt = this.board.getRank()
                .flatMapToInt(r->r.getPawnPosition(color))
                 .boxed()
                 .collect(Collectors.groupingBy(arg -> arg, HashMap::new, Collectors.counting()));

        return pawnCnt.values().stream()
                .filter(p -> p >= 2)
                .mapToDouble(p -> p * -0.5)
                .sum();
    }

    public List<Piece> sortPiecesByScore(Piece.Color color, boolean asend) {
        Comparator cmp = asend ? Comparator.comparing(Piece::getScore)
                : Comparator.comparing(Piece::getScore).reversed();

        return this.board.getRank()
                .flatMap(r -> r.getPieceOfColor(color))
                .sorted(cmp).toList();
    }
}
