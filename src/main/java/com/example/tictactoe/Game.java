package com.example.tictactoe;

/** Runs a single game between two players. */
public class Game {
    private final Board board = new Board();
    private final Player first;
    private final Player second;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public Board getBoard() { return board; }

    /** Plays until the game ends and returns the winner, or null for a draw. */
    public Player play(boolean verbose) {
        Player current = first;
        while (!board.isGameOver()) {
            if (verbose) System.out.println("\n" + board);
            int move = current.chooseMove(board);
            board.place(move, current.getMark());
            if (verbose && current instanceof AIPlayer) {
                System.out.println(current.getName() + " plays " + (move + 1));
            }
            current = (current == first) ? second : first;
        }
        if (verbose) System.out.println("\n" + board);

        Mark w = board.winner();
        if (w == first.getMark()) return first;
        if (w == second.getMark()) return second;
        return null;
    }
}
