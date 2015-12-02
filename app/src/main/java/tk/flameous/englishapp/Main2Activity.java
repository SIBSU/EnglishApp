package tk.flameous.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    int numOfPlayers;
    public static Player[] players;
    int count = 0;
    Button nameButton;
    Button startButton;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameButton = (Button)findViewById(R.id.nameButtonAct2);
        startButton = (Button)findViewById(R.id.startButtonAct2);
        text = (TextView)findViewById(R.id.meetingTextAct2);

        numOfPlayers = getIntent().getExtras().getInt("chuvaki");

        String finalHello = "Всего игроков " + numOfPlayers + ", это хорошо!" +
                "\nА теперь дружно введите свои имена и жмите Start!";

        text.setText(finalHello);

        players = new Player[numOfPlayers];
    }

    public void nameClick(View view){

        if (count == 0){text.setText(numOfPlayers + " участника рвутся в бой!"); }

        TextView textView = (TextView)findViewById(R.id.nameTextAct2);
        String playerName = textView.getText().toString();

        players[count] = new Player(playerName);

        text.setText(text.getText().toString() + "\n" + (count + 1) + " " + playerName);
        count++;

        if (count == numOfPlayers){
            nameButton.setEnabled(false);
            startButton.setEnabled(true);
            text.setText(text.getText().toString() + "\nИгроки готовы!");
        }
    }

    public void startClick(View view){
        text.setText("ТУСА НАЧИНАЕТСЯ!");

        Intent gameIntent = new Intent(Main2Activity.this, GameActivity.class);
        gameIntent.putExtra("NumberOfPlayers", numOfPlayers);
        startActivity(gameIntent);
    }
}
