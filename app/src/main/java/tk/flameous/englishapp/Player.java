package tk.flameous.englishapp;

/**
 * Created by flameous on 02.12.15.
 */

public class Player{
    String name = "debug";
    int score = 0;
    int rAnswers = 0;
    int wAnswers = 0;

    Player(String name){
        this.name = name;
    }

    boolean isWin(int maxScore){
        if (score >= maxScore){return true;}
        return false;
    }
}
