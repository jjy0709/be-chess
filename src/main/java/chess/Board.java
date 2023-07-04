package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Board {
    static ArrayList[] pieces;
    private int sizeNum;
    public Board() {
        this.pieces = new ArrayList[9];
        for(int i=1;i<9;i++) this.pieces[i] = new ArrayList();
        this.sizeNum = 0;
    }

    public void initialize() {
        for(int i=1;i<9;i++){
            this.pieces[2].add(new Pawn(Pawn.BLACK));
            this.pieces[7].add(new Pawn((Pawn.WHITE)));
        }
    }

    public void print() {
        for(int i=1;i<this.pieces.length;i++){
          if(this.pieces[i].size() != 0){
              for(Object o: this.pieces[i]){
                  System.out.print(((Pawn) o).getPrint());
              }
          }
          else System.out.print("........");
          System.out.println();
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Object p: this.pieces[7]){
            stringBuilder.append(((Pawn)p).getPrint());
        }
        return stringBuilder.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Object p: this.pieces[2]){
            stringBuilder.append(((Pawn)p).getPrint());
        }
        return stringBuilder.toString();
    }

    public int size() {
        return this.sizeNum;
    }

//    public Pawn findPawn(int index) {
//        if(index < this.size())
//            return this.pieces.get(index);
//        else
//            throw new RuntimeException("Invalid Index");
//    }

//    public <T> void add(T p) throws Exception {
//        if(p instanceof Pawn)
//            this.pieces.add((Pawn) p);
//        else
//            throw new InputMismatchException("Not Pawn");
//    }
}
