package com.example.wojtekkurylo.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.black;

public class FourthQuestionActivity extends AppCompatActivity {

    CheckBox answer_one;
    CheckBox answer_two;
    CheckBox answer_three;
    CheckBox answer_four;
    int timeToast;
    String txtToastWin;
    String txtToastLoose;
    String txtToastAlmost;
    String txtToastMore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("score", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        answer_one = (CheckBox) findViewById(R.id.checkbox1);
        answer_two = (CheckBox) findViewById(R.id.checkbox2);
        answer_three = (CheckBox) findViewById(R.id.checkbox3);
        answer_four = (CheckBox) findViewById(R.id.checkbox4);

        timeToast = Toast.LENGTH_SHORT;
        txtToastWin = "Yeah ! Congrats";
        txtToastLoose = "Upss ! I prefer sth else";
        txtToastAlmost = "One answer is correct !";
        txtToastMore = "Two answers are correct !";

    }

    /**
     * This method sent selected button to method check.
     */
    public void answer(View view) {
        check(answer_one, answer_two, answer_three, answer_four);
    }

    /**
     * Method is using If-statement
     * This method is updating the score && changing buttons background (green/red)
     * && text color on Black
     * Method is displaying Toast message (Win/Loose/Almost)
     *
     * @param one   - button one;
     * @param two   - button two;
     * @param three - button three;
     * @param four  - button four;
     */
    private void check(CheckBox one, CheckBox two, CheckBox three, CheckBox four) {
        if (answer_one.isChecked() && answer_four.isChecked()) {
            one.setBackgroundResource(R.drawable.button_answer_correct);
            one.setTextColor(ContextCompat.getColor(this, black));
            four.setBackgroundResource(R.drawable.button_answer_correct);
            four.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            three.setBackgroundResource(R.drawable.button_answer_incorrect);
            three.setTextColor(ContextCompat.getColor(this, black));

            // Toast message - Win
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastWin, timeToast);
            omega.show();
            score = +1;
            displayScore(score);

        } else if (answer_two.isChecked() && answer_three.isChecked()) {
            one.setBackgroundResource(R.drawable.button_answer_correct);
            one.setTextColor(ContextCompat.getColor(this, black));
            four.setBackgroundResource(R.drawable.button_answer_correct);
            four.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            three.setBackgroundResource(R.drawable.button_answer_incorrect);
            three.setTextColor(ContextCompat.getColor(this, black));

            // Toast message - Upss !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastLoose, timeToast);
            omega.show();
            displayScore(score);

        } else if (answer_two.isChecked() && answer_two.isChecked()) {
            one.setBackgroundResource(R.drawable.button_answer_correct);
            one.setTextColor(ContextCompat.getColor(this, black));
            four.setBackgroundResource(R.drawable.button_answer_correct);
            four.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            three.setBackgroundResource(R.drawable.button_answer_incorrect);
            three.setTextColor(ContextCompat.getColor(this, black));

            // Toast message - Almost !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastAlmost, timeToast);
            omega.show();
            displayScore(score);

        } else if (answer_one.isChecked() && answer_three.isChecked()) {
            one.setBackgroundResource(R.drawable.button_answer_correct);
            one.setTextColor(ContextCompat.getColor(this, black));
            four.setBackgroundResource(R.drawable.button_answer_correct);
            four.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            three.setBackgroundResource(R.drawable.button_answer_incorrect);
            three.setTextColor(ContextCompat.getColor(this, black));

            // Toast message - Almost !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastAlmost, timeToast);
            omega.show();
            displayScore(score);

        } else if (answer_two.isChecked() && answer_four.isChecked()) {
            one.setBackgroundResource(R.drawable.button_answer_correct);
            one.setTextColor(ContextCompat.getColor(this, black));
            four.setBackgroundResource(R.drawable.button_answer_correct);
            four.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            three.setBackgroundResource(R.drawable.button_answer_incorrect);
            three.setTextColor(ContextCompat.getColor(this, black));

            // Toast message - Almost !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastAlmost, timeToast);
            omega.show();
            displayScore(score);

        } else if (answer_three.isChecked() && answer_four.isChecked()) {
            one.setBackgroundResource(R.drawable.button_answer_correct);
            one.setTextColor(ContextCompat.getColor(this, black));
            four.setBackgroundResource(R.drawable.button_answer_correct);
            four.setTextColor(ContextCompat.getColor(this, black));
            two.setBackgroundResource(R.drawable.button_answer_incorrect);
            two.setTextColor(ContextCompat.getColor(this, black));
            three.setBackgroundResource(R.drawable.button_answer_incorrect);
            three.setTextColor(ContextCompat.getColor(this, black));

            // Toast message - Almost !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastAlmost, timeToast);
            omega.show();
            displayScore(score);
        } else {
            // Toast message - More !
            Context alfa = this;
            Toast omega = Toast.makeText(alfa, txtToastMore, timeToast);
            omega.show();
        }
    }

    /**
     * This method is changing activity and extracting the value of int score
     */
    public void nextQuestion(View view) {
        Intent myIntent = new Intent(FourthQuestionActivity.this, ResultsQuestionActivity.class);
        myIntent.putExtra("score", score);
        FourthQuestionActivity.this.startActivity(myIntent);
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
