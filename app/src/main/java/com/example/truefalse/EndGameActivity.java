package com.example.truefalse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    private TextView textViewFinalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        wireWidgets();

        Intent lastIntent = getIntent();
        int score = lastIntent.getIntExtra(GameActivity.EXTRA_SCORE, 0);

        textViewFinalScore.setText("Final Score: " + score);
    }

    private void wireWidgets() {
        textViewFinalScore = findViewById(R.id.textView_main_finalScore);
    }
}
