package utils;

import chess.pieces.Enums.Color;
import chess.pieces.Piece;

public class ExceptionUtils {
    public static final String CANNOT_MOVE_BLANK = "빈 칸은 이동할 수 없습니다.";
    public static final String INVALID_POSITION = "유효하지 않은 위치입니다.";
    public static final String ALREADY_PIECE_EXIST = "이미 같은 색의 기물이 존재하는 위치입니다.";
    private ExceptionUtils() {
    }
    public static IllegalArgumentException getExceptionForPieceNotMove(Piece piece) {
        return new IllegalArgumentException(String.format("%s이 이동 가능한 곳이 아닙니다.", piece.getType()));
    }

    public static IllegalArgumentException getExceptionForJumpOtherPiece(Piece piece) {
        return new IllegalArgumentException(String.format("%s은 다른 기물을 넘어 이동할 수 없습니다.", piece.getType()));
    }

    public static IllegalArgumentException getExceptionNotRightTurn(Color color) {
        return new IllegalArgumentException(String.format("%s의 차례입니다.", color.toString()));
    }

}
