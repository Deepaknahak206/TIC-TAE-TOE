package tictaetoe;

import tictaetoe.Controller.GameController;
import tictaetoe.ExceptionHandling.InvalidBotcount;
import tictaetoe.Model.Game;
import tictaetoe.Model.GameStatus;

import java.util.ArrayList;

public class Main {
    public  static  void main(String[]args) throws InvalidBotcount {
        GameController gc = new GameController();
      Game g =  gc.StartGame(3,new ArrayList<>(),new ArrayList<>());
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
    }
}
