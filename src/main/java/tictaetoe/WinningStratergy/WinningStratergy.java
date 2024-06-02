package tictaetoe.WinningStratergy;

import tictaetoe.Model.Board;
import tictaetoe.Model.Player;

public interface WinningStratergy {
    public boolean checkwinner(Player p , Board b) ;
}
