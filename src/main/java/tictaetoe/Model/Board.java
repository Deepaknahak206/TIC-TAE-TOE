package tictaetoe.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    private  int size ;
    List<List<Cell>> board ;

    public Board(int d) {
        this.size = d ;
        for(int i=0;i<d;i++){
            board.add(new ArrayList<>()) ;
            for(int j=0;j<d;j++){
        board.get(i).add(new Cell(i,j)) ;
            }
        }
    }

    public void printBoard(){
        for(List<Cell> row : board){
            for(Cell cell : row){
                cell.display();
            }
            System.out.println();
        }
    }
}
