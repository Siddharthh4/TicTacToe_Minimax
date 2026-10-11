package com.example.tictactoe;

/** Abstraction over anything that can pick a move (polymorphism). */
public abstract class Player {
    private final String name;
    private final Mark mark;

    protected Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() { return name; }
    public Mark getMark() { return mark; }

    /** Returns a board index (0-8) for the next move. */
    public abstract int chooseMove(Board board);
}
