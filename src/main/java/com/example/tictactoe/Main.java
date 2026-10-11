package com.example.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Tic-Tac-Toe vs Minimax AI ===");
        System.out.print("Do you want to go first? (y/n): ");
        boolean humanFirst = !scanner.nextLine().trim().equalsIgnoreCase("n");

        Player human = new HumanPlayer("You", humanFirst ? Mark.X : Mark.O, scanner);
        Player ai = new AIPlayer("Computer", humanFirst ? Mark.O : Mark.X);

        Game game = humanFirst ? new Game(human, ai) : new Game(ai, human);
        Player winner = game.play(true);

        System.out.println(winner == null ? "It's a draw!" : winner.getName() + " won!");
    }
}
