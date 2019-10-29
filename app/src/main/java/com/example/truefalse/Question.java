package com.example.truefalse;

public class Question {

    private boolean answer;
    private String question;
    private boolean isCorrect;

    public Question(boolean answer, String question) {
        this.answer = answer;
        this.question = question;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
