package chess;

import chess.pieces.Piece;

import java.util.Scanner;

public class ChessController {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while(true){
            if(input.equals("start")){
                board.initialize();
                System.out.println(board.print());
            }
            if(input.startsWith("move")){
                String[] ipts = input.split(" ");
                board.move(ipts[1], ipts[2]);
                System.out.println(board.print());
            }
            if(input.equals("end")) return;
            input = sc.nextLine();
        }

    }
}
