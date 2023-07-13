package chess;

import chess.pieces.Piece.Color;

public class ChessView {

    public ChessView() {
    }

    public void showGetInput() {
        System.out.println("명령어를 입력하세요.");
    }

    public void showStart() {
        showGetInput();
        System.out.println("게임이 시작되었습니다.");
    }

    public void showWrongInput() {
        System.out.println("잘못된 입력입니다.");
    }

    public void showGameBoard(ChessGame chessGame) {
        System.out.print(chessGame.getBoardRepresentation());
    }

    public void showGameScore(ChessGame chessGame) {
        System.out.println(String.format("WHITE 점수: %.1f", chessGame.getGameScoreOf(Color.WHITE)));
        System.out.println(String.format("BLACK 점수: %.1f", chessGame.getGameScoreOf(Color.BLACK)));
    }

    public void showNotStarted() {
        System.out.println("게임이 시작되지 않았습니다.");
    }
}
