package tictactoe;

public enum CellValue {

    PLAYER_ONE('X'),
    PLAYER_TWO('O'),
    EMPTY(' ');


    private char value;

    CellValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);

    }
}
