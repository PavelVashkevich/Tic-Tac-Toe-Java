package tictactoe.impl;

import tictactoe.Cell;
import tictactoe.CellValue;
import tictactoe.GameTable;

import java.util.ArrayList;

public class GameTableImpl implements GameTable {
    CellValue[][] gameTable;

    public GameTableImpl() {
        gameTable = new CellValue[ConstantValue.FIELD_SIZE][ConstantValue.FIELD_SIZE];
        initGameTable();
    }

    private void initGameTable(){
        for(int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize(); j++){
                gameTable[i][j] = CellValue.EMPTY;
            }
        }
    }

    @Override
    public void setValue(int rowIndex, int colIndex, CellValue value) {
        if(rowIndex >= 0 && rowIndex <= getSize() && colIndex >= 0 && colIndex <= getSize()){

            gameTable[rowIndex][colIndex] = value;
        }else {
            throw new IllegalArgumentException("Coordinates should be from 1 to " + getSize() + "!");
        }
    }



    @Override
    public CellValue getValue(int rowIndex, int colIndex) {
        if(rowIndex >= 0 && rowIndex < getSize() && colIndex >= 0 && colIndex < getSize()) {
            return gameTable[rowIndex][colIndex];
        }else {
            throw new IllegalArgumentException("Coordinates should be from 1 to " + getSize()+ "!");
        }
    }

    @Override
    public int getSize() {
        return gameTable.length;
    }

    @Override
    public boolean isCellFree(int rowIndex, int colIndex) {
        if(rowIndex >= 0 && rowIndex < getSize() && colIndex >= 0 && colIndex < getSize()) {
            return gameTable[rowIndex][colIndex] == CellValue.EMPTY;
        }else {
            throw new IllegalArgumentException("Coordinates should be from 1 to " + getSize()+ "!");
        }
    }

    @Override
    public boolean emptyCellsExist() {
        for(int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize(); j++){
                if(gameTable[i][j] == CellValue.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printTable() {
        System.out.println("---------");
        for(int i = 0; i < getSize(); i++){
            System.out.print("| ");
            for(int j = 0; j < getSize(); j++){
                System.out.print(getValue(i, j) + " ");
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("---------");
    }

    public ArrayList<Cell> getEmptyCells(){
        ArrayList<Cell> emptyCells = new ArrayList<>();
        for(int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize(); j++){
                if(getValue(i, j) == CellValue.EMPTY){
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        return emptyCells;
    }

    public void setGameTable(CellValue[][] gameTable) {
        this.gameTable = gameTable;
    }
}