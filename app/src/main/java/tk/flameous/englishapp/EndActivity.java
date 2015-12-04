package tk.flameous.englishapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    public void onBackPressed(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Player[] players = GameActivity.players;

        Player coolPlayer = new Player("debug");
        int max = -1;

        for (int i = 0; i < players.length; i++ ){
            if (players[i].score > max){
                max = players[i].score;
                coolPlayer = players[i];
            }
        }

        TextView textView = (TextView)findViewById(R.id.EndText);
        textView.setText(coolPlayer.name + " WIN!" + "\nscore: " + coolPlayer.score);

        String allScores = "";

        for (int i = 0; i < players.length; i++ ){
            allScores += players[i].name + " - " + players[i].score + "\n";
        }

        TextView scoreText = (TextView)findViewById(R.id.endScore);
        scoreText.setText(allScores);
    }

    public void goodBye(View view){
        this.finish();
    }

}