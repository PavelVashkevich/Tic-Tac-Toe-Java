package tictactoe;

import java.util.ArrayList;

public interface GameTable {

    void setValue(int rowIndex, int collIndex, CellValue value);

    CellValue getValue(int rowIndex, int colIndex);

    boolean isCellFree(int rowIndex, int colIndex);

    boolean emptyCellsExist();

    int getSize();

    void printTable();

    ArrayList<Cell> getEmptyCells();
}
