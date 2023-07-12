package chess;

import chess.Board.Board;
import chess.Board.Position;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessGame {
    static Board board = new Board();

    public ChessGame() {
    }

    public void initialize() {
        this.board.initialize();
    }

    public void initializeEmpty() {
        this.board.initializeEmpty();
    }

    public double getGameScoreOf(Color color) {
        if (!checkKingAlive(color)) return 0.;
        return getTotalPoint(color) + getPenaltyPoint(color);
    }

    private boolean checkKingAlive(Color color) {
        return this.board.getRank().anyMatch(r -> r.checkKingAlive(color));
    }

    private double getTotalPoint(Color color) {
        return this.board.getRank()
                .mapToDouble(r -> r.calculateScore(color))
                .sum();
    }

    private double getPenaltyPoint(Color color) {
        Map<Integer, Long> pawnCnt = this.board.getRank()
                .flatMapToInt(r -> r.getPawnPosition(color))
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

    public static boolean checkPieceColorDiffer(Piece piece, Position position) {
        return board.getPieceAt(position).getColor() != piece.getColor();
    }

    public void move(Position source, Position destination) throws Exception {
        board.move(source, destination);
    }

    public String getBoardRepresentation() {
        return board.getBoardString();
    }
}
