package tictactoe;

import tictactoe.exceptions.BadInputException;
import tictactoe.realisation.TicTac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Input command: ");
                if(sc.hasNextLine()) {
                    String[] arguments = sc.nextLine().split("\\s+");
                    switch (arguments[0]) {
                        case "start":
                            if(arguments.length > 1) {
                                TicTac titTacGame = new TicTac();
                                titTacGame.initGame(arguments[1], arguments[2]);
                                titTacGame.startGame();
                                break;
                            }else {
                                throw new BadInputException("Bad parameters!");
                            }
                        case "exit":
                            return;
                        default:
                            throw new BadInputException("Bad parameters!");
                    }
                } else {
                    throw new BadInputException("Bad parameters!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
