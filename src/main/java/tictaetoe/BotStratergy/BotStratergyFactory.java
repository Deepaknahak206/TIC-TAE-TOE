package tictaetoe.BotStratergy;

import tictaetoe.Model.BotDifficulty;

public class BotStratergyFactory {
    public static BotStratergy getStratergyBasedOnLevel(BotDifficulty b){
        if(b.equals(BotDifficulty.Easy)){
            return new EasyBotStratergy() ;
        }
        return null ;
    }
}
