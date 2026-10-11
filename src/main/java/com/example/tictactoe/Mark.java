package com.example.tictactoe;

/** The symbol a player places on the board. */
public enum Mark {
    X, O, EMPTY;

    public Mark opposite() {
        return switch (this) {
            case X -> O;
            case O -> X;
            case EMPTY -> EMPTY;
        };
    }

    @Override
    public String toString() {
        return this == EMPTY ? " " : name();
    }
}
