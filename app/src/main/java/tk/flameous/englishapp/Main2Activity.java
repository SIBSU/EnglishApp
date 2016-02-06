package tk.flameous.englishapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private int numOfPlayers;
    public static Player[] players;
    private int count = 0;
    private Button nameButton;
    private Button startButton;
    private TextView text;

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

        EditText userNameText = (EditText) findViewById(R.id.nameTextAct2);
        userNameText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                nameClick(v);
                return true;
            }
        });
    }

    public void nameClick(View view){

        if (count == 0){text.setText(numOfPlayers + " участника рвутся в бой!"); }

        TextView textView = (TextView)findViewById(R.id.nameTextAct2);
        String playerName = textView.getText().toString();


        String empty = "";
        if (playerName.equals(empty)){text.setText("Enter your name, please!"); }
        else {
            players[count] = new Player(playerName);

            text.setText(text.getText().toString() + "\n" + (count + 1) + ": " + playerName);
            count++;
            if (count == numOfPlayers) {
                nameButton.setEnabled(false);
                startButton.setEnabled(true);
                text.setText(text.getText().toString() + "\nИгроки готовы!");

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(startButton.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
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
