package tictactoe;

public interface Player {

    void setGameTable(GameTable gameTable);

    Cell move();
}
