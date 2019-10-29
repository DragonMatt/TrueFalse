package com.example.truefalse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private Button buttonTrue;
    private Button buttonFalse;
    private Quiz game;

    public static final String EXTRA_SCORE = "score";

    public static final String TAG = GameActivity.class.getSimpleName();

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        wireWidgets();
        setListeners();

        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.questions); // getting XML
        String jsonString = readTextFile(XmlFileInputStream);

        Gson gson = new Gson();
        Question[] questions = gson.fromJson(jsonString, Question[].class);
        List<Question> questionList = Arrays.asList(questions);
        Log.d(TAG, "onCreate: " + questionList.toString());

        game = new Quiz(questionList);

        updateGameDisplay();
    }

    private void updateGameDisplay() {
        textViewQuestion.setText(String.valueOf(game.getListOfQuestions().get(game.getCurrentQuestion() - 1).getQuestion()));
        textViewScore.setText("Score: " + game.getScore());
    }

    private void wireWidgets() {
        textViewQuestion = findViewById(R.id.textView_main_question);
        textViewScore = findViewById(R.id.textView_main_score);
        buttonTrue = findViewById(R.id.button_main_true);
        buttonFalse = findViewById(R.id.button_main_false);
    }

    private void setListeners() {
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.checkAnswer(true);
                if(!game.hasQuestions()) {
                    int score = game.getScore();
                    Intent targetIntent = new Intent(GameActivity.this, EndGameActivity.class);
                    targetIntent.putExtra(EXTRA_SCORE, score);
                    startActivity(targetIntent);
                    finish();
                }
                updateGameDisplay();
            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.checkAnswer(false);
                if(!game.hasQuestions()) {
                    int score = game.getScore();
                    Intent targetIntent = new Intent(GameActivity.this, EndGameActivity.class);
                    targetIntent.putExtra(EXTRA_SCORE, score);
                    startActivity(targetIntent);
                    finish();
                }
                updateGameDisplay();
            }
        });
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}