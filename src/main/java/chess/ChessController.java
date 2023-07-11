package chess;

import chess.pieces.Piece;

import java.util.Scanner;

public class ChessController {
    public static void main(String[] args) {
        Board board = new Board();
        ChessView chessView = new ChessView(board);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while(true){
            if(input.equals("start")){
                board.initialize();
                System.out.println(chessView.view());
            }
            if(input.startsWith("move")){
                String[] ipts = input.split(" ");
                try {
                    board.move(ipts[1], ipts[2]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(chessView.view());
            }
            if(input.equals("end")) return;
            input = sc.nextLine();
        }

    }
}
