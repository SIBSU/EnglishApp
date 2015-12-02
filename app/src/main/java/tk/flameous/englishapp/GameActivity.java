package tk.flameous.englishapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Player[] players;
    int numOfPlayers;
    TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        players = Main2Activity.players;
        numOfPlayers = getIntent().getExtras().getInt("NumberOfPlayers");
        questionText = (TextView)findViewById(R.id.questionText);
    }

    public void gameClick(View view){
        int num;

        switch (view.getId()){
            case R.id.button1: num = 1;
                break;
            case R.id.button2: num = 2;
                break;
            case R.id.button3: num = 3;
                break;
            default: num = 4;
                break;
        }

        questionText.setText("Нажата кнопка " + num);
    }
}
