package tictaetoe.Model;

import lombok.Data;

@Data
public class Player {
    private int id ;
    private String Name ;
    private PlayerType playerType ;
    private Symbol symbol ;
}
