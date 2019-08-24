package tictactoe.impl;

import tictactoe.Cell;
import tictactoe.CellValue;
import tictactoe.GameTable;
import tictactoe.Player;

import java.util.Objects;
import java.util.Scanner;

public class HumanPlayerImpl implements Player {

    private final Scanner sc = new Scanner(System.in);
    private GameTable gameTable;
    private CellValue cellValue;

    public HumanPlayerImpl(CellValue cellValue){
        this.cellValue = cellValue;
    }

    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell move() {

        System.out.print("Enter the coordinates: ");
        int rowIndex = sc.nextInt();
        int colIndex = sc.nextInt();
        if(gameTable.isCellFree(gameTable.getSize() - colIndex, 2 - (gameTable.getSize() - rowIndex))) {
            gameTable.setValue(gameTable.getSize() - colIndex, 2 - (gameTable.getSize() - rowIndex), cellValue);
        }else {
            throw new IllegalArgumentException("This cell is occupied! Choose another one!");
        }
        return new Cell(rowIndex, colIndex);
    }

}
