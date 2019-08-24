package tictactoe.impl;

import tictactoe.Cell;
import tictactoe.CellValue;
import tictactoe.GameTable;
import tictactoe.Player;

import java.util.ArrayList;
import java.util.Objects;

public class HardComputerPlayerImpl implements Player {
    private GameTable gameTable;
    private CellValue cellValue;
    private WinnerCheckerImpl winnerChecker;


    public HardComputerPlayerImpl(CellValue cellValue) {
        this.cellValue = cellValue;
    }

    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
        winnerChecker = new WinnerCheckerImpl();
    }

    @Override
    public Cell move() {
        System.out.println("Making move level \"hard\"");

        GameTableImpl copyGameTable = new GameTableImpl();
        copyGameTable.setGameTable(getCopyOfGetTable());

        Move bestMove = miniMax(copyGameTable, 1);

        gameTable.setValue(bestMove.getCell().getRowIndex(), bestMove.getCell().getColIndex(), cellValue);
        return bestMove.getCell();
    }

    private CellValue getOpponent(){
        return cellValue == CellValue.PLAYER_ONE ? CellValue.PLAYER_TWO : CellValue.PLAYER_ONE;

    }

    private Move miniMax(GameTable copyTable, int turn){

        ArrayList<Cell> availableCells = copyTable.getEmptyCells();
        winnerChecker.setGameTable(copyTable);

        CellValue opponentValue = getOpponent();
        ArrayList<Move> moves = new ArrayList<>();


        if(availableCells.isEmpty()){
            return new Move(0);
        }

        if(winnerChecker.isWinnerFound(cellValue)) {
            return new Move(10);
        }
        if(winnerChecker.isWinnerFound(opponentValue)){
            return new Move(-10);
        }

        for (int i = 0; i < availableCells.size(); i++) {

            Cell emptyCell = availableCells.get(i);

            if (turn == 1) {
                copyTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), cellValue);
                Move move = miniMax(copyTable,2);
                move.setCell(emptyCell);
                moves.add(move);

            }
            if (turn == 2) {

                copyTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), opponentValue);
                Move move = miniMax(copyTable, 1);
                move.setCell(emptyCell);
                moves.add(move);

            }
            copyTable.setValue(emptyCell.getRowIndex(), emptyCell.getColIndex(), CellValue.EMPTY);
        }

        int bestMove = 0;
        if(turn == 1){
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < moves.size(); i++){
                int currentScore = moves.get(i).getScore();
                if(currentScore > bestScore){
                    bestScore = currentScore;
                    bestMove = i;
                }
            }
        }else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < moves.size(); i++){
                int currentScore = moves.get(i).getScore();
                if(currentScore < bestScore){
                    bestScore = currentScore;
                    bestMove = i;
                }
            }
        }
        return moves.get(bestMove);
    }

    private CellValue[][] getCopyOfGetTable(){
        CellValue[][] copyOfGableTable = new CellValue[gameTable.getSize()][gameTable.getSize()];
        for(int i = 0; i < copyOfGableTable.length; i++){
            for (int j = 0; j < copyOfGableTable.length; j++){
                copyOfGableTable[i][j] = gameTable.getValue(i, j);
            }
        }
        return copyOfGableTable;
    }

    @Override
    public String toString() {
        return cellValue.toString();
    }


    private final class Move{
        private int score;
        private Cell cell;

        private Move(int score) {
            this.score = score;
        }

        private Cell getCell() {
            return cell;
        }

        void setCell(Cell cell) {
            this.cell = cell;
        }

        int getScore() {
            return score;
        }

    }

}