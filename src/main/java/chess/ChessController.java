package chess;

import java.util.Scanner;

public class ChessController {
    public static void main(String[] args) {
        Board board;
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        while(true){
            if(input.equals("start")){
                board = new Board();
                board.initialize();
                System.out.println(board.print());
            }
            if(input.equals("end")) return;
            input = sc.next();
        }

    }
}
