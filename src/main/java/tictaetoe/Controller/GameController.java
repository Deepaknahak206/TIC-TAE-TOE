package tictaetoe.Controller;

import tictaetoe.ExceptionHandling.InvalidBotcount;
import tictaetoe.Model.Game;
import tictaetoe.Model.GameStatus;
import tictaetoe.Model.Player;
import tictaetoe.WinningStratergy.WinningStratergy;

import java.util.List;

public class GameController {

    public Game StartGame(int dimension , List<Player> p, List<WinningStratergy> winningStratergies) throws InvalidBotcount {
        // Create Game Object
       Game game = Game.getInstanceBuider()
                .setDimension(dimension)
                .setPlayers(p)
                .setWinningStratergies(winningStratergies)
                .build();
       return game ;
        // Game.getInstanceBuilder().addPlayer(p1).addPlayer(p2)
        // addWinningStratergy(w1).addWinningStratergy(w2).
        }
    public void displayBoard(Game game){
        game.getBoard().printBoard(); ;
    }
    public  void makeMove(Game game){
        //TODO
    }
    public GameStatus checkstatus(Game g){
        return null ;
        //Implement Tomorrow
    }
    public Player getWinner(Game g){
        return g.getWinner() ;
    }
    public  void undo(Game g){
        // TODO
    }
}


//Client -> gamecontroller
//1. start the game ..-> create Game object
//2.While game state in progress.