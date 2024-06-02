package tictaetoe.Model;

import lombok.Data;

@Data
public class Cell {
    private int row ;
    private int col ;
    private Player player ;
    private CellState cellState ;
}
