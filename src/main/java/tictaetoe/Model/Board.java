package tictaetoe.Model;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private  int size ;
    List<List<Cell>> board ;

    public Board(int d) {
        this.size = d ;
    }

    public void printBoard(){
        // TODO
    }
}
