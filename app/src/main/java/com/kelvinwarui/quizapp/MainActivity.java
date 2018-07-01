package com.kelvinwarui.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
            new TrueFalse(R.string.question_13, true),
            new TrueFalse(R.string.goodbye)

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

                if (counter < 12 && mQuestionBank[counter].isAnswer() ) {
                    Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                    counter++;
                    Log.d("counter",mQuestionBank.length+"");
                    score++;


                    mScore.setText("Score "+score+""+"/"+13+"");
                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());


                } else if(counter < 12 && mQuestionBank[counter].isAnswer() == false ){
                    Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    counter++;
                    Log.d("counter",counter+"");
                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                }else if(counter == 12){

                mQuestionTextView.setText("Congratulations your score is "+score);
                mTrue.setVisibility(View.GONE);
                    mFalse.setVisibility(View.GONE);
            }


                break;
            case R.id.false_button:
                mAnswer = false;

                if (  counter < 12 && mQuestionBank[counter].isAnswer()  ) {
                    Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    counter++;
                    Log.d("counter",counter+"");
                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                } else if(counter < 12 && mQuestionBank[counter].isAnswer() == false ){
                    Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                    counter++;
                    score++;
                    Log.d("counter",counter+"");
                    mScore.setText("Score "+score+""+"/"+13+"");

                    mQuestionTextView.setText(mQuestionBank[counter].getQuestion());

                }

               else if(counter == 12){

                    mQuestionTextView.setText("Congratulations your score is "+score);
                    mFalse.setVisibility(View.GONE);
                    mTrue.setVisibility(View.GONE);
                }





                break;
        }

    }
}
