package tk.flameous.englishapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int numOfPlayers = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void anotherClick(View view){
        TextView textAct1 = (TextView)findViewById(R.id.editTextAct1);
        String strPlayers = textAct1.getText().toString();

        switch (strPlayers){
            case "2": numOfPlayers = 2;
                break;
            case "3": numOfPlayers = 3;
                break;
            case "4": numOfPlayers = 4;
                break;
            default:
                break;
        }

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        this.finish();
    }
}
