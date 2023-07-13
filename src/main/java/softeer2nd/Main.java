package softeer2nd;

import chess.ChessGame;
import chess.ChessView;
import chess.board.Board;

import java.util.Arrays;
import java.util.Scanner;

import static utils.StringUtils.*;

public class Main {
    private static ChessGame chessGame = new ChessGame(new Board());
    private static ChessView chessView = new ChessView();
    private static boolean gameStarted = false;
    private static boolean gameEnded = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chessView.showGetInput();
        String input = sc.nextLine();

        while (true) {
            if (input.equals(START)) {
                start();
            } else if (input.equals(END)) {
                gameStarted = false;
                chessView.showGameEnd();
                return;
            } else if (!gameStarted) {
                chessView.showNotStarted();
            } else if (input.startsWith(MOVE)) {
                move(input);
            } else if (input.equals(SCORE)) {
                chessView.showGameScore(chessGame);
            } else {
                chessView.showWrongInput();
            }

            if (gameEnded) {
                return;
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

        if (inputSplit.length != 3) {
            chessView.showWrongInput();
            return;
        }

        try {
            chessGame.move(inputSplit[1], inputSplit[2]);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            gameEnded = true;
        }

        chessView.showGameBoard(chessGame);
    }

}
