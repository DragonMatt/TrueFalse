package com.example.truefalse;

import android.widget.Toast;

import java.util.List;

public class Quiz {

    private List<Question> listOfQuestions;
    private int currentQuestion;
    private int score;

    public Quiz(List<Question> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
        currentQuestion = 1;
    }

    public List<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void checkAnswer(boolean answer) {
        if (answer == listOfQuestions.get(currentQuestion - 1).getAnswer()) {
            score++;
        }
        currentQuestion++;
    }

    public boolean hasQuestions() {
        if(currentQuestion >= listOfQuestions.size()) {
            return false;
        }
        else {
            return true;
        }
    }
}