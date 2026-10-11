package com.example.tictactoe;

import java.util.Scanner;

/** A player that reads moves from the console. */
public class HumanPlayer extends Player {
    private final Scanner scanner;

    public HumanPlayer(String name, Mark mark, Scanner scanner) {
        super(name, mark);
        this.scanner = scanner;
    }

    @Override
    public int chooseMove(Board board) {
        while (true) {
            System.out.print(getName() + " (" + getMark() + "), choose a cell 1-9: ");
            String line = scanner.nextLine().trim();
            try {
                int index = Integer.parseInt(line) - 1;
                if (board.isValidMove(index)) return index;
            } catch (NumberFormatException ignored) {
                // fall through to the error message
            }
            System.out.println("Invalid move, try again.");
        }
    }
}
