package tk.flameous.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private int numOfPlayers;
    public static Player[] players;
    int numOfPPlayer = 0;

    private int questionsCount = 0;
    private int numOfQuestions;
    private Question[] questions;

    private TextView questionText;

    @Override
    public void onBackPressed(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionText = (TextView)findViewById(R.id.questionText);

        players = Main2Activity.players;
        numOfPlayers = MainActivity.numOfPlayers;

        String[] qArray = getResources().getStringArray(R.array.questions);
        String[] ansArray = getResources().getStringArray(R.array.answers);
        int[] rAnswers = getResources().getIntArray(R.array.rightAnswers);

        numOfQuestions = qArray.length;
        questions = new Question[numOfQuestions];


        for (int i = 0; i < numOfQuestions; i++){
            questions[i] = new Question(qArray[i], ansArray[i], rAnswers[i]);
        }

        String firstQuestion = "The first question for " + players[numOfPPlayer].name + "\n"
                + questions[0].question + "\n\n" + questions[0].answers;

        questionText.setText(firstQuestion);
    }

    public void getAnswer(int a){
        if (questions[questionsCount].isRight(a)) {players[numOfPPlayer].score++; }
    }

    public void gameClick(View view){
        switch (view.getId()){
            case R.id.button1: getAnswer(1);
                break;
            case R.id.button2: getAnswer(2);
                break;
            case R.id.button3: getAnswer(3);
                break;
            default: getAnswer(4);
                break;
        }

        if (questionsCount == (numOfQuestions - 1)){
            Intent intent = new Intent(GameActivity.this, EndActivity.class);
            startActivity(intent);
            this.finish();
        }
        else {questionsCount++; }

        if (numOfPPlayer == numOfPlayers - 1) {numOfPPlayer = 0; }
        else { numOfPPlayer++; }

        // LOL
        String notFirstQuestion = "Question for " + players[numOfPPlayer].name +
                "(score: " + players[numOfPPlayer].score +  ")" + "\n" +
                questions[questionsCount].question + "\n\n" + questions[questionsCount].answers;

        questionText.setText(notFirstQuestion);
    }
}