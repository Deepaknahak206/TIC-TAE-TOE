package tictaetoe.Model;

import lombok.Data;

@Data
public class Cell {
    private int row ;
    private int col ;
    private Player player ;
    private CellState cellState ;
    public Cell(int row , int col){
        this.row = row ;
        this.col = col ;
        this.player = null ;
        this.cellState = CellState.Empty ;
    }
    public void display(){
        if(player==null){
            System.out.println("| - |");
        }else{
            System.out.println("| "+player.getSymbol().getSymbol()+" |");
        }
    }
}
