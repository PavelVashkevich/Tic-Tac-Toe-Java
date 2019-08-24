package tictactoe;

public interface WinnerChecker {

    void setGameTable(GameTable gameTable);

    boolean isWinnerFound(CellValue cellValue);
}
