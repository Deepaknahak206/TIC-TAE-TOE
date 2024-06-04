package tictaetoe.Model;

import ch.qos.logback.core.joran.spi.ElementPath;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tictaetoe.ExceptionHandling.InvalidBotcount;
import tictaetoe.WinningStratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Setter
@Getter
public class Game {
    @Setter
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
   public boolean validate(Move m){
       int row = m.getCell().getRow() ;
       int col = m.getCell().getCol() ;
       if(row>board.getSize()){
           return false ;
       }
       if(col>board.getSize()){
           return false ;
       }
       return board.getBoard().get(row).get(col).getCellState().equals(CellState.Empty) ;
   }
   public void makeMove(){
       Player currrentplayer1 = players.get(Nextplayerturn) ;
       System.out.println("Current turn is "+ currrentplayer1.getName());
       Move m = currrentplayer1.makemove(board) ;
       if(!validate(m)){
           System.out.println("invalid Move");
           return ;
       }

       int row = m.getCell().getRow() ;
       int col = m.getCell().getCol() ;
       Cell cellToupdate = board.getBoard().get(row).get(col) ;
       cellToupdate.setCellState(CellState.Filled);
       cellToupdate.setPlayer(currrentplayer1);

       Move Undomoves = new Move(cellToupdate,currrentplayer1) ;
      moves.add(Undomoves) ;
      Nextplayerturn+=1 ;
      Nextplayerturn %=players.size() ;
   }
    public  static  Builder getInstanceBuider(){

        return  new Builder();
    }

    public Board getBoard() {
       return board ;
    }

    public static  class Builder{
      private  List<Player> players ;
      private int dimension ;
      private  List<WinningStratergy> winningStratergies ;
        private char[] symbol ;
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
          // Symbol Validation
       HashSet<Character> hs = new HashSet<>() ;
        for(char s:symbol){
            if(hs.contains(s)){
                throw new IllegalArgumentException("Dupliacte Symbol is present") ;
            }else {
                hs.add(s) ;
            }
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
