package com.example.wojtekkurylo.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.R.attr.value;

public class InstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst);
    }

    /**
     * This method is changing activity;
     */
    public void startQuiz(View view) {
        Intent myIntent = new Intent(InstActivity.this, FirstQuestionActivity.class);
        InstActivity.this.startActivity(myIntent);
    }
}
