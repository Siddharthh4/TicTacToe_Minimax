package com.example.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void detectsRowWin() {
        Board b = new Board();
        b.place(0, Mark.X); b.place(1, Mark.X); b.place(2, Mark.X);
        assertEquals(Mark.X, b.winner());
    }

    @Test
    void rejectsOccupiedCell() {
        Board b = new Board();
        b.place(4, Mark.O);
        assertThrows(IllegalArgumentException.class, () -> b.place(4, Mark.X));
    }

    @Test
    void aiTakesWinningMove() {
        Board b = new Board();
        b.place(0, Mark.O); b.place(1, Mark.O);
        b.place(3, Mark.X); b.place(4, Mark.X);
        assertEquals(2, new AIPlayer("AI", Mark.O).chooseMove(b));
    }

    @Test
    void aiBlocksOpponent() {
        Board b = new Board();
        b.place(0, Mark.X); b.place(1, Mark.X);
        b.place(4, Mark.O);
        assertEquals(2, new AIPlayer("AI", Mark.O).chooseMove(b));
    }

    @Test
    void twoAIsAlwaysDraw() {
        Game g = new Game(new AIPlayer("A", Mark.X), new AIPlayer("B", Mark.O));
        assertNull(g.play(false));
    }
}
