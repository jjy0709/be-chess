package softeer2nd;

import chess.board.Board;
import chess.board.Position;
import chess.ChessGame;
import chess.ChessView;

import java.util.Scanner;

import static utils.StringUtils.*;

public class Main {
    private static ChessGame chessGame = new ChessGame(new Board());
    private static ChessView chessView = new ChessView();
    private static boolean gameStarted = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chessView.showStart();
        String input = sc.nextLine();

        while (true) {
            if (input.equals(START)) {
                start();
            } else if (!gameStarted ){
                chessView.showNotStarted();
            } else if (input.startsWith(MOVE)) {
                move(input);
            } else if (input.equals(SCORE)) {
                chessView.showGameScore(chessGame);
            } else if (input.equals(END)) {
                gameStarted = false;
                return;
            } else {
                chessView.showWrongInput();
            }

            chessView.showGetInput();
            input = sc.nextLine();
        }

    }

    private static void start() {
        chessGame.initialize();
        chessView.showGameBoard(chessGame);
        gameStarted = true;
    }

    private static void move(String input) {
        String[] inputSplit = input.split(" ");
        try {
            chessGame.move(new Position(inputSplit[1]), new Position(inputSplit[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        chessView.showGameBoard(chessGame);
    }
}
