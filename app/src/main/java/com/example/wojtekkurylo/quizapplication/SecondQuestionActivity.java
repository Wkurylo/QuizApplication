package com.example.wojtekkurylo.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.black;
import static com.example.wojtekkurylo.quizapplication.R.string.questionFour;

public class SecondQuestionActivity extends AppCompatActivity {

    Button check_text;
    //    Button answer_two;
    int timeToast;
    String txtToastWin;
    String txtToastLoose;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        this.score = extras.getInt("score", this.score);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        check_text = (Button) findViewById(R.id.check_text);
//        answer_two = (Button) findViewById(R.id.answer2);
        timeToast = Toast.LENGTH_SHORT;
        txtToastWin = "Yeah ! That is right";
        txtToastLoose = "Upss ! I prefer strawberries";

    }

    /**
     * This method sent answer to method check.
     */
    public void checkAnswer(View view) {
        questionFour();
    }

    /**
     * Method is using If-statement
     * This method is updating the score and checking if answer is correct
     * Method is displaying Toast message (Win/Loose)
     *
     * setEnabled(false) method Is giving the user only 1 change to answer
     */

    public void questionFour() {
        EditText question_four = (EditText) findViewById(R.id.editText);
        if (question_four.getText().toString().toLowerCase().equals(getString(R.string.editTextAnswer))) {
            // Toast message - Win
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastWin, timeToast);
            omega.show();
            score += 1;
            displayScore(this.score);
        } else {
            // Toast message - Upss !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastLoose, timeToast);
            omega.show();
            displayScore(this.score);
        }
        check_text.setEnabled(false);
    }

    /**
     * This method is changing activity and extracting the value of int score
     */
    public void nextQuestion(View view) {
        Intent myIntent = new Intent(SecondQuestionActivity.this, ThirdQuestionActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("score", this.score);
        myIntent.putExtras(extras);
        SecondQuestionActivity.this.startActivity(myIntent);
    }

    /**
     * This method is just for test purpose;
     * to check If the new activity is taking the value of int score form previous activity;
     * to check If method updating the score is working correctly;
     */
    private void displayScore(int number) {
        this.score = number;
        TextView quantityTextView = (TextView) findViewById(R.id.score_text_view);
        quantityTextView.setText("" + this.score);
    }

}
