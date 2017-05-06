package com.example.wojtekkurylo.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.black;

public class ThirdQuestionActivity extends AppCompatActivity {

    RadioButton answer_one;
    RadioButton answer_two;
    int timeToast;
    String txtToastWin;
    String txtToastLoose;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        this.score = extras.getInt("score", this.score);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        answer_one = (RadioButton) findViewById(R.id.radioButtonOne);
        answer_two = (RadioButton) findViewById(R.id.radioButtonTwo);

        timeToast = Toast.LENGTH_SHORT;
        txtToastWin = "Yeah ! Congrats";
        txtToastLoose = "Upss ! I am lucky You are not my doctor";

    }

    /**
     * Method is using switch
     * This method sent selected button to method correct && incorrect.
     */
    public void answer(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonOne:
                if (checked)
                    incorrect(answer_one, answer_two); // calling method incorrect with input
                break;
            case R.id.radioButtonTwo:
                if (checked)
                    correct(answer_two, answer_one); // calling method correct with input
                break;
        }
    }

    /**
     * Method is using switch
     * This method is changing buttons background (green/red)
     * && text color on Black
     * Method is displaying Toast message - Loose
     *
     * @param one - RadioButton one;
     * @param two - RadioButton two;
     */
    private void incorrect(RadioButton one, RadioButton two) {
        one.setBackgroundResource(R.drawable.button_answer_incorrect);
        one.setTextColor(ContextCompat.getColor(this, black));
        two.setBackgroundResource(R.drawable.button_answer_correct);
        two.setTextColor(ContextCompat.getColor(this, black));

        // Toast message - Upss !
        Context alfa = this;
        Toast omega = Toast.makeText(alfa, txtToastLoose, timeToast);
        omega.show();
        displayScore(this.score);
    }

    /**
     * Method is using switch
     * This method is updating score && changing buttons background (green/red)
     * && text color on Black
     * Method is displaying Toast message - Win
     *
     * @param one - RadioButton one;
     * @param two - RadioButton two;
     */
    private void correct(RadioButton two, RadioButton one) {
        two.setBackgroundResource(R.drawable.button_answer_correct);
        two.setTextColor(ContextCompat.getColor(this, black));
        one.setBackgroundResource(R.drawable.button_answer_incorrect);
        one.setTextColor(ContextCompat.getColor(this, black));

        //Toast message - Win
        Context alfa = this;
        Toast omega = Toast.makeText(alfa, txtToastWin, timeToast);
        omega.show();
        this.score += 1;
        displayScore(this.score);
    }

    /**
     * This method is changing activity and extracting the value of int score
     */
    public void nextQuestion(View view) {
        Intent myIntent = new Intent(ThirdQuestionActivity.this, FourthQuestionActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("score", this.score);
        myIntent.putExtras(extras);
        ThirdQuestionActivity.this.startActivity(myIntent);
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
