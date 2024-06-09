package tictaetoe.Model;

import lombok.Data;
import tictaetoe.BotStratergy.BotStratergy;
import tictaetoe.BotStratergy.BotStratergyFactory;

@Data
public class Bot extends Player{
    BotDifficulty botDifficulty ;
    BotStratergy stratergy ;
    public Bot(int id , String Name,Symbol s , BotDifficulty botDifficulty){
         super(id,Name,PlayerType.BOT,s);
         this.botDifficulty = botDifficulty ;
        this.stratergy = BotStratergyFactory.getStratergyBasedOnLevel(botDifficulty) ;
    }
    public void setDifficulty (BotDifficulty botDifficulty){
        this.botDifficulty = botDifficulty ;
    }


    public Move makeMove (Board b){
        Move m = stratergy.makeMove(b) ;
        m.setPlayer(this);
        return m ;
    }
}
