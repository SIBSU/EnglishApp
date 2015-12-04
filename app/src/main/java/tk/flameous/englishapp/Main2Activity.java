package tk.flameous.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private int numOfPlayers;
    public static Player[] players;
    private int count = 0;
    private Button nameButton;
    private Button startButton;
    private TextView text;
    private String empty = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameButton = (Button)findViewById(R.id.nameButtonAct2);
        startButton = (Button)findViewById(R.id.startButtonAct2);
        text = (TextView)findViewById(R.id.meetingTextAct2);

        numOfPlayers = MainActivity.numOfPlayers;

        String finalHello = "Всего игроков " + numOfPlayers + ", это хорошо!" +
                "\nА теперь дружно введите свои имена и жмите Start!";

        text.setText(finalHello);

        players = new Player[numOfPlayers];
    }

    public void nameClick(View view){

        if (count == 0){text.setText(numOfPlayers + " участника рвутся в бой!"); }

        TextView textView = (TextView)findViewById(R.id.nameTextAct2);
        String playerName = textView.getText().toString();


        if (playerName.equals(empty)){text.setText("Enter your name, please!"); }
        else {
            players[count] = new Player(playerName);

            text.setText(text.getText().toString() + "\n" + (count + 1) + ": " + playerName);
            count++;
            if (count == numOfPlayers) {
                nameButton.setEnabled(false);
                startButton.setEnabled(true);
                text.setText(text.getText().toString() + "\nИгроки готовы!");
            }
        }
        textView.setText(empty);
    }

    public void startClick(View view){
        Intent gameIntent = new Intent(Main2Activity.this, GameActivity.class);
        startActivity(gameIntent);
        this.finish();
    }
}
