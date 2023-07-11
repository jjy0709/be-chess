package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessGame {
    static Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public ChessGame() {
        this.board = new Board();
    }

    public void init() {
        this.board.initialize();
    }

    public void emptyInit() {
        this.board.initializeEmpty();
    }

    public double calculateScore(Color color) {
        if (!checkKingAlive(color)) return 0.;
        return calculatePointSum(color) + calculatePenaltyPoint(color);
    }

    private boolean checkKingAlive(Color color) {
        return this.board.getRank().anyMatch(r -> r.checkKingAlive(color));
    }

    private double calculatePointSum(Color color) {
        return this.board.getRank()
                .mapToDouble(r -> r.calculateScore(color))
                .sum();
    }

    private double calculatePenaltyPoint(Color color) {
        Map<Integer, Long> pawnCnt = this.board.getRank()
                .flatMapToInt(r->r.getPawnPosition(color))
                 .boxed()
                 .collect(Collectors.groupingBy(arg -> arg, HashMap::new, Collectors.counting()));

        return pawnCnt.values().stream()
                .filter(p -> p >= 2)
                .mapToDouble(p -> p * -0.5)
                .sum();
    }

    public List<Piece> sortPiecesByScore(Color color, boolean asend) {
        Comparator cmp = asend ? Comparator.comparing(Piece::getScore)
                : Comparator.comparing(Piece::getScore).reversed();

        return this.board.getRank()
                .flatMap(r -> r.getPieceOfColor(color))
                .sorted(cmp).toList();
    }

    public static Piece getPieceAtPosition(Position position) {
        return board.getPieceAt(position);
    }
}
