package tictactoe.impl;

import tictactoe.CellValue;
import tictactoe.GameTable;
import tictactoe.WinnerChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinnerCheckerImpl implements WinnerChecker {

    private GameTable gameTable;
    private int winCount = ConstantValue.WIN_COUNT;


    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public boolean isWinnerFound(CellValue cellValue) {

        boolean result = isWinnerFoundByRow(cellValue);
        if (result) {
            return true;
        }

        result = isWinnerFoundByCol(cellValue);
        if (result) {
            return true;
        }

        result = isWinnerFoundByMainDiagonal(cellValue);
        if (result) {
            return true;
        }

        result = isWinnerFoundByNotMainDiagonal(cellValue);
        if (result) {
            return true;
        }

        return false;

    }

    @SuppressWarnings("Duplicates")
    private boolean isWinnerFoundByRow(CellValue cellValue) {
        for (int i = 0; i < gameTable.getSize(); i++) {
            List<CellValue> cells = new ArrayList<>();
            for (int j = 0; j < gameTable.getSize(); j++) {
                if (gameTable.getValue(i, j) == cellValue) {
                    cells.add(cellValue);

                    if (cells.size() == winCount) {
                        return true;
                    }
                } else {
                    cells.clear();
                }
            }
        }
        return false;
    }

    @SuppressWarnings("Duplicates")
    private boolean isWinnerFoundByCol(CellValue cellValue) {
        for (int i = 0; i < gameTable.getSize(); i++) {
            List<CellValue> cells = new ArrayList<>();
            for (int j = 0; j < gameTable.getSize(); j++) {
                if (gameTable.getValue(j, i) == cellValue) {
                    cells.add(cellValue);

                    if (cells.size() == winCount) {
                        return true;
                    }
                } else {
                    cells.clear();
                }
            }
        }
        return false;
    }

    @SuppressWarnings("Duplicates")
    private boolean isWinnerFoundByMainDiagonal(CellValue cellValue) {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                List<CellValue> cells = new ArrayList<>();
                for (int k = 0; k < gameTable.getSize(); k++) {
                    if (gameTable.getValue(i + k, j + k) == cellValue) {
                        cells.add(cellValue);

                        if (cells.size() == winCount) {
                            return true;
                        }
                    } else {
                        cells.clear();
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("Duplicates")
    private boolean isWinnerFoundByNotMainDiagonal(CellValue cellValue) {
        for (int i = 0; i < 1; i++) {
            for (int j = 2; j < 3; j++) {
                List<CellValue> cells = new ArrayList<>();
                for (int k = 0; k < gameTable.getSize(); k++) {
                    if (gameTable.getValue(i + k, j - k) == cellValue) {
                        cells.add(cellValue);

                        if (cells.size() == winCount) {
                            return true;
                        }
                    } else {
                        cells.clear();
                    }
                }
            }
        }
        return false;
    }
}