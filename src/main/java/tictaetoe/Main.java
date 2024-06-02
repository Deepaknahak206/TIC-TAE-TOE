package tictaetoe;

import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import tictaetoe.Controller.GameController;
import tictaetoe.ExceptionHandling.InvalidBotcount;
import tictaetoe.Model.*;
import tictaetoe.WinningStratergy.ColWinningStratergy;
import tictaetoe.WinningStratergy.DiagonalwWiningStratergy;
import tictaetoe.WinningStratergy.RowWinningStratergy;
import tictaetoe.WinningStratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public  static  void main(String[]args) throws InvalidBotcount {

        GameController gc = new GameController();

        try{
            int dimension = 5 ;
            List<Player> p = new ArrayList<>();
            p.add(new Player(1,"Deepak", PlayerType.Human,new Symbol('D'))) ;
            p.add(new Player(2,"PAPA", PlayerType.Human,new Symbol('P'))) ;
            p.add(new Player(3,"MOM", PlayerType.Human,new Symbol('M'))) ;
            p.add(new Bot(4,"Pradeep", new Symbol('B'),BotDifficulty.Hard)) ;
            List<WinningStratergy> ws = List.of(new ColWinningStratergy(),
                                                new DiagonalwWiningStratergy(),
                                                new RowWinningStratergy()) ;
            Game g = gc.StartGame(5,p,ws) ;
            gc.displayBoard(g);
            while(g.getGameStatus().equals(GameStatus.Inprogress)){
                gc.makeMove(g);
                gc.displayBoard(g);
            }
            if(g.getGameStatus().equals(GameStatus.Draw)){
                System.out.println("Game draw");
            }else if(g.getGameStatus().equals(GameStatus.Win)){
                System.out.println("Game winner"+g.getWinner().getName());
            }
        }catch (Exception e){
            throw e ;
        }
    }
}
