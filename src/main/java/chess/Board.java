package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Board {
    static ArrayList<Pawn> pieces;
    public Board() {
        this.pieces = new ArrayList<>();
    }

    public int size() {
        return this.pieces.size();
    }

    public Pawn findPawn(int index) {
        return this.pieces.get(index);
    }

    public <T> void add(T p) throws Exception {
        if(p instanceof Pawn)
            this.pieces.add((Pawn) p);
        else
            throw new InputMismatchException("Not Pawn");
    }
}
