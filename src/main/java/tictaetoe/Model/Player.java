package tictaetoe.Model;

import lombok.Data;

import java.util.Scanner;

@Data
public class Player {
    private int id ;
    private String Name ;
    private PlayerType playerType ;
    private Symbol symbol ;
    Scanner sc ;
    public Player(int id , String Name,PlayerType playerType,Symbol s){
        this.id = id ;
        this.Name = Name ;
        this.playerType = playerType ;
        this.symbol = s ;
        this.sc = new Scanner(System.in) ;
    }
    public Move makemove(Board b){
        System.out.println("defined row");

    }
}
