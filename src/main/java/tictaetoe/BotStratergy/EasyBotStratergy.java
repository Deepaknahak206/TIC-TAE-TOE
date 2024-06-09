package tictaetoe.BotStratergy;

import tictaetoe.Model.Board;
import tictaetoe.Model.Cell;
import tictaetoe.Model.CellState;
import tictaetoe.Model.Move;

import java.util.List;

public class EasyBotStratergy implements  BotStratergy{
    @Override
    public Move makeMove(Board b) {
        for(List<Cell> row : b.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.Empty)){
                    return new Move(cell,null) ;
                }
            }
        }
        return null ;
    }
}
