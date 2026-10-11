package com.example.tictactoe;

/**
 * Computer player powered by the Minimax algorithm with alpha-beta pruning.
 * It searches the full game tree, so it never loses.
 */
public class AIPlayer extends Player {

    public AIPlayer(String name, Mark mark) {
        super(name, mark);
    }

    @Override
    public int chooseMove(Board board) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;
        Board sim = new Board(board);

        for (int move : sim.availableMoves()) {
            sim.place(move, getMark());
            int score = minimax(sim, false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            sim.undo(move);
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int minimax(Board board, boolean maximizing, int depth, int alpha, int beta) {
        Mark winner = board.winner();
        if (winner == getMark()) return 10 - depth;               // prefer faster wins
        if (winner == getMark().opposite()) return depth - 10;    // prefer slower losses
        if (board.isFull()) return 0;

        Mark turn = maximizing ? getMark() : getMark().opposite();
        int best = maximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int move : board.availableMoves()) {
            board.place(move, turn);
            int score = minimax(board, !maximizing, depth + 1, alpha, beta);
            board.undo(move);

            if (maximizing) {
                best = Math.max(best, score);
                alpha = Math.max(alpha, best);
            } else {
                best = Math.min(best, score);
                beta = Math.min(beta, best);
            }
            if (beta <= alpha) break; // prune
        }
        return best;
    }
}
