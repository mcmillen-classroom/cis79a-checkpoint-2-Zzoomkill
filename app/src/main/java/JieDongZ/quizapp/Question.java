package JieDongZ.quizapp;

public class Question {
    private int mTextResId;
    private int mHintTextResId;
    private boolean mAnswer;


    public Question(int textResId, int hintTextResId, boolean answer) {
        mTextResId = textResId;
        mHintTextResId=hintTextResId;
        mAnswer = answer;
    }

    public int getTextResId() {
        return mTextResId;
    }
    public int getHintTextResId() {
        return mHintTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
