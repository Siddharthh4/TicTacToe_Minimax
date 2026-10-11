package com.example.tictactoe;

import java.util.ArrayList;
import java.util.List;

/** Encapsulates the 3x3 grid and the rules for winning / drawing. */
public class Board {
    public static final int SIZE = 3;
    private static final int[][] LINES = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},   // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},   // columns
        {0, 4, 8}, {2, 4, 6}               // diagonals
    };

    private final Mark[] cells = new Mark[SIZE * SIZE];

    public Board() {
        for (int i = 0; i < cells.length; i++) cells[i] = Mark.EMPTY;
    }

    /** Copy constructor, used by the AI to simulate moves. */
    public Board(Board other) {
        System.arraycopy(other.cells, 0, this.cells, 0, cells.length);
    }

    public Mark get(int index) {
        return cells[index];
    }

    public boolean isValidMove(int index) {
        return index >= 0 && index < cells.length && cells[index] == Mark.EMPTY;
    }

    public void place(int index, Mark mark) {
        if (!isValidMove(index)) {
            throw new IllegalArgumentException("Invalid move: " + index);
        }
        cells[index] = mark;
    }

    public void undo(int index) {
        cells[index] = Mark.EMPTY;
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == Mark.EMPTY) moves.add(i);
        }
        return moves;
    }

    /** Returns the winning mark, or EMPTY if nobody has won yet. */
    public Mark winner() {
        for (int[] l : LINES) {
            Mark m = cells[l[0]];
            if (m != Mark.EMPTY && m == cells[l[1]] && m == cells[l[2]]) return m;
        }
        return Mark.EMPTY;
    }

    public boolean isFull() {
        return availableMoves().isEmpty();
    }

    public boolean isGameOver() {
        return winner() != Mark.EMPTY || isFull();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int i = r * SIZE + c;
                String label = cells[i] == Mark.EMPTY ? String.valueOf(i + 1) : cells[i].toString();
                sb.append(' ').append(label).append(' ');
                if (c < SIZE - 1) sb.append('|');
            }
            sb.append('\n');
            if (r < SIZE - 1) sb.append("---+---+---\n");
        }
        return sb.toString();
    }
}
