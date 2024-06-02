package tictaetoe.Model;

import lombok.Data;
@Data

public class Symbol {
    private char symbol ;
    public Symbol(char s){
        this.symbol = s ;
    }
}
