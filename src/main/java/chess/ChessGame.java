package chess;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.Enums.Color;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static utils.ExceptionUtils.*;

public class ChessGame {
    private Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public void initialize() {
        this.board.initialize();
    }

    public void initializeEmpty() {
        this.board.initializeEmpty();
    }

    public double getGameScoreOf(Color color) {
        if (!checkKingAlive(color)) {
            return 0.;
        }
        return getTotalPoint(color) + getPenaltyPoint(color);
    }

    private boolean checkKingAlive(Color color) {
        return this.board.getPieceListOfColor(color).stream()
                .anyMatch(Piece::isKing);
    }

    private double getTotalPoint(Color color) {
        return this.board.getPieceListOfColor(color).stream()
                .mapToDouble(Piece::getScore)
                .sum();
    }

    private double getPenaltyPoint(Color color) {
        return Arrays.stream(this.board.getPawnCountOfEachColumn(color)).asDoubleStream()
                .filter(count -> count > 1.)
                .map(count -> count * -0.5)
                .sum();
    }

    public List<Piece> sortPiecesByScore(Color color, boolean asend) {
        Comparator<Piece> cmp = Comparator.comparing(Piece::getScore);
        if(!asend){
            cmp = Comparator.comparing(Piece::getScore).reversed();
        }

        return this.board.getPieceListOfColor(color).stream()
                .sorted(cmp)
                .toList();
    }

    public void move(String source, String destination) throws IllegalArgumentException {
        Position sourcePosition = new Position(source);
        Position destinationPosition = new Position(destination);
        checkPositionRange(sourcePosition, destinationPosition);
        board.move(sourcePosition, destinationPosition);
    }

    private void checkPositionRange(Position source, Position destination) throws IllegalArgumentException {
        if (!source.inBoard() || !destination.inBoard()) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
    }

    public void movePiece(Position position, Piece piece) {
        board.movePiece(position, piece);
    }

    public String getBoardRepresentation() {
        return board.getBoardString();
    }
}
