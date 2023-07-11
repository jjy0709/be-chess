package chess;

import chess.pieces.Piece;

import java.util.Scanner;

public class ChessController {
    public static void main(String[] args) {
        Board board = new Board();
        ChessView chessView = new ChessView(board);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (true) {
            if (input.equals("start")) {
                board.initialize();
                System.out.println(chessView.view());
            }
            if (input.startsWith("move")) {
                String[] inputSplit = input.split(" ");
                try {
                    board.move(new Position(inputSplit[1]), new Position(inputSplit[2]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(chessView.view());
            }
            if (input.equals("end")) return;
            input = sc.nextLine();
        }

    }
}
