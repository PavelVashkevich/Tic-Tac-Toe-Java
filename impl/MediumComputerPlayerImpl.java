package tictactoe.impl;

import tictactoe.Cell;
import tictactoe.CellValue;
import tictactoe.GameTable;
import tictactoe.Player;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MediumComputerPlayerImpl implements Player {
    private GameTable gameTable;
    private CellValue cellValue;
    private int winCount = ConstantValue.WIN_COUNT;

    public MediumComputerPlayerImpl(CellValue cellValue){
        this.cellValue = cellValue;
    }



    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell move() {
        System.out.println("Making move level \"medium\"");
        Cell result = makeMoveByRow();
        if(result != null){
            return result;
        }

        result = makeMoveByCol();
        if(result != null){
            return result;
        }

        result = makeMoveByMainDiagonal();
        if(result != null){
            return result;
        }

        result = makeMoveByNotMainDiagonal();
        if(result != null){
            return result;
        }

        result = makeRandomMove();
        if(result != null){
            return result;
        }
        return null;
    }

    @SuppressWarnings("Duplicates")
    private Cell makeMoveByRow(){
        Cell emptyCell = null;

        for(int i = 0; i < gameTable.getSize(); i++){
            int countXinRow = 0;
            int countOinRow = 0;
            for (int j = 0; j < gameTable.getSize(); j++){
                if(gameTable.getValue(i, j) == CellValue.PLAYER_ONE){
                    countXinRow++;
                }else if(gameTable.getValue(i, j) == CellValue.PLAYER_TWO){
                    countOinRow++;
                }else {
                    emptyCell = new Cell(i, j);
                }
            }
            if((countXinRow == winCount - 1 || countOinRow == winCount - 1) && emptyCell != null){
                gameTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), cellValue);
                return emptyCell;
            }
        }
        return null;
    }
    @SuppressWarnings("Duplicates")
    private Cell makeMoveByCol(){
        Cell emptyCell = null;
        for(int i = 0; i < gameTable.getSize(); i++){
            int countXinCol = 0;
            int countOinCol = 0;
            for (int j = 0; j < gameTable.getSize(); j++){
                if(gameTable.getValue(j, i) == CellValue.PLAYER_ONE){
                    countXinCol++;
                }else if(gameTable.getValue(j, i) == CellValue.PLAYER_TWO){
                    countOinCol++;
                }else {
                    emptyCell = new Cell(j, i);
                }
            }
            if((countXinCol == winCount - 1 || countOinCol == winCount - 1) && emptyCell != null){
                gameTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), cellValue);
                return emptyCell;
            }
        }
        return null;
    }
    @SuppressWarnings("Duplicates")
    private Cell makeMoveByMainDiagonal(){
        Cell emptyCell = null;
        for(int i = 0; i < gameTable.getSize(); i++){
            int countXinDiagonal = 0;
            int countOinDiagonal = 0;
            if(gameTable.getValue(i, i) == CellValue.PLAYER_ONE){
                countXinDiagonal++;
            }else if(gameTable.getValue(i, i) == CellValue.PLAYER_TWO){
                countOinDiagonal++;
            }else{
                emptyCell = new Cell(i, i);
            }
            if((countXinDiagonal == winCount - 1 || countOinDiagonal == winCount - 1) && emptyCell != null){
                gameTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), cellValue);
                return emptyCell;
            }
        }
        return null;
    }

    private Cell makeMoveByNotMainDiagonal(){
        Cell emptyCell = null;
        int sizeMinus1 = gameTable.getSize() - 1;
        for(int i = 0; i <= sizeMinus1; i++){
            int countXinDiagonal = 0;
            int countOinDiagonal = 0;
            if(gameTable.getValue(i, sizeMinus1 - i) == CellValue.PLAYER_ONE){
                countXinDiagonal++;
            }else if(gameTable.getValue(i, sizeMinus1 - i) == CellValue.PLAYER_TWO){
                countOinDiagonal++;
            }else{
                emptyCell = new Cell(i, sizeMinus1 - i);
            }
            if((countXinDiagonal == winCount - 1 || countOinDiagonal == winCount - 1) && emptyCell != null){
                gameTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), cellValue);
                return emptyCell;
            }
        }
        return null;
    }


    private ArrayList<Cell> getEmptyCells(){
        ArrayList<Cell> emptyCells = new ArrayList<>();
        for(int i = 0; i < gameTable.getSize(); i++){
            for (int j = 0; j < gameTable.getSize(); j++){
                if(gameTable.getValue(i, j) == CellValue.EMPTY){
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        return emptyCells;
    }

    private Cell makeRandomMove(){
        ArrayList<Cell> emptyCells = getEmptyCells();
        if(!emptyCells.isEmpty()) {
            Cell emptyCell = emptyCells.get(new Random().nextInt(emptyCells.size()));
            gameTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), cellValue);
        }
        return null;
    }
}