package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;

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

    public void add(Pawn p) {
        this.pieces.add(p);
    }
}
