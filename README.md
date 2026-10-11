# Tic-Tac-Toe vs Minimax AI (Java)

A small console game in pure Java where you play Tic-Tac-Toe against an unbeatable AI. No external AI libraries or APIs — the AI is the classic **Minimax algorithm with alpha-beta pruning**.

## OOP concepts demonstrated
| Concept | Where |
|---|---|
| Abstraction | `Player` abstract class |
| Inheritance | `HumanPlayer`, `AIPlayer` extend `Player` |
| Polymorphism | `Game` calls `chooseMove()` without knowing the player type |
| Encapsulation | `Board` hides its grid and exposes rule methods |
| Enums | `Mark` (X, O, EMPTY) |

## Java ecosystem
Maven (build), JUnit 5 (tests), GitHub Actions (CI).

## Run
Requires JDK 17+ and Maven.

```bash
mvn test                 # run unit tests
mvn package              # build the jar
java -jar target/tictactoe-minimax-ai-1.0.0.jar
```

## How the AI works
`AIPlayer` simulates every possible future game. A win scores `10 - depth`, a loss `depth - 10`, a draw `0`. It picks the move with the best score, and alpha-beta pruning skips branches that can't change the result. Result: the best you can do is draw.

## Ideas to extend
- Add a difficulty level (random moves some of the time)
- Swing/JavaFX GUI
- Larger boards with depth-limited search
