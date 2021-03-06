package com.example.wojtekkurylo.quizapplication;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsQuestionActivity extends AppCompatActivity {

    EditText email;
    EditText name;
    String resultMessage;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        this.score = extras.getInt("score", this.score);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name_view);
        // Message which is sent by email to user
        resultMessage = "\n\n" + getString(R.string.resultMessage);
        resultMessage += "\n\n\n" + getString(R.string.resultMessageTwo) + this.score;

    }

    /**
     * This method is sending value of score to method displayMessage.
     */
    public void submitScore(View view) {
        String message = "Your score: ";
        displayMessage(message, this.score);
    }

    /**
     * This method displays the score value on the screen.
     */
    private void displayMessage(String message, int score) {
        this.score = score;
        TextView questionTextView = (TextView) findViewById(R.id.question);
        questionTextView.setTextColor(Color.BLACK);
        questionTextView.setTextSize(25);
        questionTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        questionTextView.setText(message + this.score);
        Toast.makeText(this, message + this.score, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method is changing activity to the "FirstQuestionActivity" - to restart game
     */
    public void restart(View view) {
        Intent myIntent = new Intent(ResultsQuestionActivity.this, FirstQuestionActivity.class);
        ResultsQuestionActivity.this.startActivity(myIntent);
    }

    /**
     * This method is sending email with game results
     * String message - message which is sent to the user.
     * Message is using name && email typed by user in EditText view
     */
    public void sentEmail(View view) {
        String message = "Hey " + name.getText() + "," + resultMessage;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email.getText()));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Secrets of Pets Life - Quiz App");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
