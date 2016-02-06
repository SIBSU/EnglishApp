package tk.flameous.englishapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int numOfPlayers = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText userCountText = (EditText) findViewById(R.id.editTextAct1);
        userCountText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                anotherClick(v);
                return true;
            }
        });

        userCountText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                char putChar = event.getNumber();

                int count;
                try {
                    count = Integer.decode(String.valueOf(putChar));
                } catch (NumberFormatException e) {
                    return false;
                }

                if (userCountText.getText().length() > 0) {
                    return true;
                }
                if (count < 1) {
                    userCountText.setText("1");
                    userCountText.setSelection(1);
                    return true;
                }
                if (count > 4) {
                    userCountText.setText("4");
                    userCountText.setSelection(1);
                    return true;
                }

                return false;
            }
        });
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
