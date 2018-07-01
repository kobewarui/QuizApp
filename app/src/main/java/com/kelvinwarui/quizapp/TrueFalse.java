package com.kelvinwarui.quizapp;

public class TrueFalse {

    private int mQuestion;
    private boolean mAnswer;

    public int getQuestion() {
        return mQuestion;
    }

    public boolean isAnswer() {
        return mAnswer;
    }



    public TrueFalse(int questionId,boolean bool){
        this.mQuestion = questionId;
        this.mAnswer = bool;

    }
    public TrueFalse(int question ){
        this.mQuestion = question ;
    }
}
