package chess;

import static chess.pieces.Enums.Color.*;

public class ChessView {

    public ChessView() {
    }

    public void showGetInput() {
        System.out.println("명령어를 입력하세요.");
    }

    public void showWrongInput() {
        System.out.println("잘못된 입력입니다.");
    }

    public void showGameBoard(ChessGame chessGame) {
        System.out.print(chessGame.getBoardRepresentation());
    }

    public void showGameScore(ChessGame chessGame) {
        System.out.println(String.format("WHITE 점수: %.1f", chessGame.getGameScoreOf(WHITE)));
        System.out.println(String.format("BLACK 점수: %.1f", chessGame.getGameScoreOf(BLACK)));
    }

    public void showNotStarted() {
        System.out.println("게임이 시작되지 않았습니다.");
    }

    public void showGameEnd() {
        System.out.println("게임을 종료합니다.");
    }
}
