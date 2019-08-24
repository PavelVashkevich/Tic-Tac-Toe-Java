package tictactoe.impl;

import tictactoe.Cell;
import tictactoe.CellValue;
import tictactoe.GameTable;
import tictactoe.Player;

import java.util.Objects;
import java.util.Random;

public class EasyComputerPlayerImpl implements Player {

    private GameTable gameTable;
    private CellValue cellValue;


    public EasyComputerPlayerImpl(CellValue cellValue){
        this.cellValue = cellValue;
    }
    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell move() {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int randomColIndex =  random.nextInt(3) + 1;
        int randomRowIndex =  random.nextInt(3) + 1;

        while (!(gameTable.isCellFree(gameTable.getSize() - randomColIndex, 2 - (gameTable.getSize() - randomRowIndex)))){
            randomColIndex =  random.nextInt(3) + 1;
            randomRowIndex =  random.nextInt(3) + 1;
        }
        gameTable.setValue(gameTable.getSize() - randomColIndex, 2 - (gameTable.getSize() - randomRowIndex), cellValue);

        return new Cell(randomRowIndex, randomColIndex);
    }
}