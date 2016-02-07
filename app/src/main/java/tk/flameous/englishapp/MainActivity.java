package tk.flameous.englishapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int numOfPlayers = 1;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        fourButton = (Button) findViewById(R.id.fourButton);
    }

    public void selectClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.oneButton:
                numOfPlayers = 1;
                oneButton.setEnabled(false);
                twoButton.setEnabled(true);
                threeButton.setEnabled(true);
                fourButton.setEnabled(true);
                break;
            case R.id.twoButton:
                numOfPlayers = 2;
                oneButton.setEnabled(true);
                twoButton.setEnabled(false);
                threeButton.setEnabled(true);
                fourButton.setEnabled(true);
                break;
            case R.id.threeButton:
                numOfPlayers = 3;
                oneButton.setEnabled(true);
                twoButton.setEnabled(true);
                threeButton.setEnabled(false);
                fourButton.setEnabled(true);
                break;
            case R.id.fourButton:
                numOfPlayers = 4;
                oneButton.setEnabled(true);
                twoButton.setEnabled(true);
                threeButton.setEnabled(true);
                fourButton.setEnabled(false);
                break;
        }
    }

    public void anotherClick(View view){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        this.finish();
    }
}
