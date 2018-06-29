package com.kelvinwarui.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    Button mTrue, mFalse;
    TextView mQuestionTextView, mScore;
    boolean mAnswer = false;
    int counter = 0;
    int score = 0;


    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, false),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, true),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateViews();
        mTrue.setOnClickListener(this);
        mFalse.setOnClickListener(this);


    }

    private void updateViews() {
        mFalse = findViewById(R.id.false_button);
        mTrue = findViewById(R.id.true_button);
        mScore = findViewById(R.id.score);
        mQuestionTextView = findViewById(R.id.question_text_view);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.true_button:
                mAnswer = true;

                if (mQuestionBank[counter].isAnswer()) {
                    Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                    counter++;
                    score++;


                    mScore.setText("Score "+score+""+"/"+13+"");
                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                } else {
                    Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    counter++;

                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                }


                break;
            case R.id.false_button:
                mAnswer = false;

                if (mQuestionBank[counter].isAnswer()) {
                    Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    counter++;

                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                } else {
                    Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                    counter++;
                    score++;

                    mScore.setText("Score "+score+""+"/"+13+"");
                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                }

                break;
        }

    }
}
