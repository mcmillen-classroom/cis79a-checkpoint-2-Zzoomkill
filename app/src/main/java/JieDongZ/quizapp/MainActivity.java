package JieDongZ.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private TextView ScoreTextView;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private Button mHintButton;

    private Question[] mQuestions;
    private int mIndex;
    private int mScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPreviousButton=(ImageButton) findViewById(R.id.previous_button);
        mHintButton = (Button) findViewById(R.id.hint_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        ScoreTextView = (TextView) findViewById(R.id.score_view);

        //array
        mQuestions = new Question[5];
        mIndex = 0;

        mQuestions[0] = new Question(R.string.question_1,R.string.question_1_hint, true);
        mQuestions[1] = new Question(R.string.question_2,R.string.question_2_hint, true);
        mQuestions[2] = new Question(R.string.question_3,R.string.question_3_hint, true);
        mQuestions[3] = new Question(R.string.question_4,R.string.question_4_hint, true);
        mQuestions[4] = new Question(R.string.question_5,R.string.question_5_hint,true);
        mTextView.setText(mQuestions[mIndex].getTextResId());
        ScoreTextView.setText("Score"+mScore);

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
            mTrueButton.setClickable(false);
            mFalseButton.setClickable(false);
        }

        else if (view.getId() == R.id.false_button) {
            checkAnswer(false);
            mTrueButton.setClickable(false);
            mFalseButton.setClickable(false);
        }


        else if (view.getId() == R.id.next_button) {
            //change the variable by one
            mIndex++;mTrueButton.setClickable(true);mFalseButton.setClickable(true);}
            //DO IF STATEMENT HERE:

        else if (view.getId() == R.id.previous_button) {
                mIndex--;mTrueButton.setClickable(true);mFalseButton.setClickable(true);}

        else if (view.getId() == R.id.hint_button) {
                Toast myToast = Toast.makeText(this, mQuestions[mIndex].getHintTextResId(), Toast.LENGTH_LONG);
                myToast.show();
            }
                //change text in view
                mTextView.setText(mQuestions[mIndex].getTextResId());
        if (mIndex>4 || mIndex<0){
            mIndex=0;
        }

            }

    public boolean checkAnswer(boolean userInput){

        if (mQuestions[mIndex].getAnswer() == userInput){
            mScore++;
            ScoreTextView.setText("Score"+mScore);

            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
            myToast.show();
            return true;
        }
        else{
            mScore--;
            ScoreTextView.setText("Score"+mScore);
            Toast myToast = Toast.makeText(this, "You are incorrect!", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }





}
