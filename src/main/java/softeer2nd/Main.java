package softeer2nd;

import chess.Board.Position;
import chess.ChessGame;
import chess.ChessView;

import java.util.Scanner;

import static utils.StringUtils.*;

public class Main {
    private static ChessGame chessGame = new ChessGame();
    private static ChessView chessView = new ChessView(chessGame);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chessView.showStart();
        String input = sc.nextLine();

        while (true) {
            if (input.equals(START)) {
                start();
            }
            else if (input.startsWith(MOVE)) {
                move(input);
            }
            else if (input.equals(SCORE)) {
                chessView.showGameScore();
            }
            else if (input.equals(END))
                return;
            else {
                chessView.showWrongInput();
            }

            chessView.showGetInput();
            input = sc.nextLine();
        }

    }

    private static void start() {
        chessGame.initialize();
        chessView.showBoard();
    }

    private static void move(String input) {
        String[] inputSplit = input.split(" ");
        try {
            chessGame.move(new Position(inputSplit[1]), new Position(inputSplit[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        chessView.showBoard();
    }
}
