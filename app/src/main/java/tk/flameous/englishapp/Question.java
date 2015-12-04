package tk.flameous.englishapp;

/**
 * Created by flameous on 02.12.15.
 */
public class Question {
    String question;
    String answers;
    int rightAnswer;

    Question(String question, String answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public boolean isRight(int num){
        return (num == rightAnswer);
    }
}
