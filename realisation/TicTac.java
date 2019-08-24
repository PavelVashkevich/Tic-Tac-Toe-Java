package tictactoe.realisation;

import tictactoe.impl.HardComputerPlayerImpl;
import tictactoe.CellValue;
import tictactoe.GameTable;
import tictactoe.Player;
import tictactoe.WinnerChecker;
import tictactoe.exceptions.BadInputException;
import tictactoe.impl.*;

public class TicTac {
    private GameTable gameTable;
    private WinnerChecker winnerChecker;
    private Player player1;
    private Player player2;


    public void initGame(String... args) {
        gameTable = new GameTableImpl();

        winnerChecker = new WinnerCheckerImpl();
        winnerChecker.setGameTable(gameTable);

        player1 = initPlayers(args[0], CellValue.PLAYER_ONE);
        player1.setGameTable(gameTable);

        player2 = initPlayers(args[1], CellValue.PLAYER_TWO);
        player2.setGameTable(gameTable);
    }

    private Player initPlayers(String arg, CellValue cellValue) {
        switch (arg) {
            case "user":
                return new HumanPlayerImpl(cellValue);
            case "easy":
                return new EasyComputerPlayerImpl(cellValue);
            case "medium":
                return new MediumComputerPlayerImpl(cellValue);
            case "hard":
                return new HardComputerPlayerImpl(cellValue);
            default:
                throw new BadInputException("Bad parameters!");
        }
    }

    public void startGame() {

        gameTable.printTable();
        while (true) {
            try {
                CellValue result;
                if (gameTable.emptyCellsExist()) {
                    player1.move();
                    gameTable.printTable();
                    if (winnerChecker.isWinnerFound(CellValue.PLAYER_ONE)) {
                        System.out.println(player1 + " wins!");
                        return;
                    }
                } else {
                    System.out.println("Draw");
                    break;
                }
                if (gameTable.emptyCellsExist()) {
                    player2.move();
                    gameTable.printTable();
                    if(winnerChecker.isWinnerFound(CellValue.PLAYER_TWO)){
                        System.out.println(player2 + " wins!");
                        return;
                    }
                } else {
                    System.out.println("Draw");
                    break;
                }

            }catch (RuntimeException e){
                System.out.println(e.getMessage());;
            }
        }

    }
}