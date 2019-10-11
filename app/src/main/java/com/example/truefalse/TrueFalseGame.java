package com.example.truefalse;

import android.util.Log;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TrueFalseGame {
    private String question;
    private String answer;
    private String[] questions;

    public TrueFalseGame() {
        createQuestions();
        generateRandomQuestion();
    }

    public void createQuestions() {
        Gson gson = new Gson();
        Question[] questions = gson.fromJson(jsonString, Question[].class);
        List<Question> questionList = Arrays.asList(questions);
        Log.d(TAG, "onCreate: " + ((List) questionList).toString());
    }

    public void generateRandomQuestion() {

    }
}
