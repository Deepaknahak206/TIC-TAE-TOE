package tictaetoe.Model;

import lombok.Data;

@Data
public class Bot extends Player{
    BotDifficulty botDifficulty ;
    public Bot(int id , String Name,Symbol s , BotDifficulty botDifficulty){
         super(id,Name,PlayerType.BOT,s);
         this.botDifficulty = botDifficulty ;
    }
}
