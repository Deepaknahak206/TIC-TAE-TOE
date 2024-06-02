package tictaetoe.Model;

import lombok.Data;
import tictaetoe.ExceptionHandling.InvalidBotcount;
import tictaetoe.WinningStratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;
@Data
public class Game {
    private Board board ;
    private  List<Player> players ;
    List<Move> moves ;
    private  Player winner ;
    private  int Nextplayerturn ;
    private  GameStatus gameStatus ;
    private  List<WinningStratergy> winningStratergies ;

   private Game(int dimension,List<Player> players, List<WinningStratergy> winningStratergies) {
       this.board= new Board(dimension) ;
       this.players = players ;
       this.Nextplayerturn = 0 ;
       this.winningStratergies= winningStratergies ;
       this.gameStatus = GameStatus.Inprogress ;
       this.winner = null ;
       this.moves = new ArrayList<>() ;
   }
    public  static  Builder getInstanceBuider(){

        return  new Builder();
    }
    public void setBoard(Board board){
       this.board= board ;
    }

    public Board getBoard() {
       return board ;
    }

    public static  class Builder{
      private  List<Player> players ;
      private int dimension ;
      private  List<WinningStratergy> winningStratergies ;
      public void validate() throws InvalidBotcount {
          int botcount = 0 ;
          for(Player p: players){
              if(p.getPlayerType().equals(PlayerType.BOT)){
                  botcount++ ;
              }
          }
          if(botcount>1){
              throw new InvalidBotcount();
          }
          if(players.size()!=dimension-1){
              throw new IllegalArgumentException();
          }
      }
      public Game build() throws InvalidBotcount {
          validate();
          return new Game(this.dimension,this.players,this.winningStratergies) ;
      }
      public List<Player> getPlayers() {
          return players;
      }

      public Builder setPlayers(List<Player> players) {
          this.players = players;
          return this;
      }
      public int getDimension() {
          return dimension;
      }
      public Builder setDimension(int dimension) {
         this.dimension = dimension ;
         return this ;
      }
      public List<WinningStratergy> getWinningStratergies() {
          return winningStratergies;
      }


      public Builder setWinningStratergies(List<WinningStratergy> winningStratergies) {
          this.winningStratergies = winningStratergies;
          return this;
      }
  }
}
