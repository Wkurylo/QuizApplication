package com.example.wojtekkurylo.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.black;

public class FirstQuestionActivity extends AppCompatActivity {

    Button answer_one;
    Button answer_two;
    Button answer_three;
    Button answer_forth;
    int timeToast;
    String txtToastWin;
    String txtToastLoose;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        answer_one = (Button) findViewById(R.id.answer1);
        answer_two = (Button) findViewById(R.id.answer2);
        answer_three = (Button) findViewById(R.id.answer3);
        answer_forth = (Button) findViewById(R.id.answer4);

        timeToast = Toast.LENGTH_SHORT;
        txtToastWin = "Yeah ! Congrats";
        txtToastLoose = "Upss ! I am lucky You are not my doctor";
        score = 0;
    }

    /**
     * This method sent selected button to method check.
     */
    public void answer(View view) {
        check(answer_one, answer_two, answer_three, answer_forth);
    }

    /**
     * Method is using If-statement
     * This method is updating the score && changing buttons background (green/red)
     * && text color on Black
     * Method is displaying Toast message (Win/Loose)
     * @param one   - button one;
     * @param two   - button two;
     * @param three - button three;
     * @param forth - button four;
     */
    private void check(Button one, Button two, Button three, Button forth) {
        if (answer_three.isPressed()) {
            three.setBackgroundResource(R.drawable.button_answer_correct);
            three.setTextColor(ContextCompat.getColor(this, black));
            one.setBackgroundResource(R.drawable.button_answer_incorrect);
            one.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            forth.setBackgroundResource(R.drawable.button_answer_incorrect);
            forth.setTextColor(ContextCompat.getColor(this, black));
            // Toast message - Win
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastWin, timeToast);
            omega.show();
            score = +1;
            displayScore(score);

        } else {
            three.setBackgroundResource(R.drawable.button_answer_correct);
            three.setTextColor(ContextCompat.getColor(this, black));
            one.setBackgroundResource(R.drawable.button_answer_incorrect);
            one.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            forth.setBackgroundResource(R.drawable.button_answer_incorrect);
            forth.setTextColor(ContextCompat.getColor(this, black));
            // Toast message - Upss !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastLoose, timeToast);
            omega.show();
            displayScore(score);
        }
    }

    /**
     * This method is changing activity and extracting the value of int score
     */
    public void nextQuestion(View view) {
        Intent myIntent = new Intent(FirstQuestionActivity.this, SecondQuestionActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("score", score);
        myIntent.putExtras(extras);
        FirstQuestionActivity.this.startActivity(myIntent);
    }

    /**
     * This method is just for test purpose;
     * to check If the new activity is taking the value of int score form previous activity;
     * to check If method updating the score is working correctly;
     */
    private void displayScore(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_text_view);
        quantityTextView.setText("" + number);
    }
}
