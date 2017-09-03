package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.android.thequizzworld.R.string.eighth_definitions_answer1;
import static com.example.android.thequizzworld.R.string.eighth_definitions_answer2;
import static com.example.android.thequizzworld.R.string.eighth_definitions_answer3;
import static com.example.android.thequizzworld.R.string.eighth_definitions_answer4;
import static com.example.android.thequizzworld.R.string.eighth_definitions_question;
import static com.example.android.thequizzworld.R.string.fifth_definitions_answer1;
import static com.example.android.thequizzworld.R.string.fifth_definitions_answer2;
import static com.example.android.thequizzworld.R.string.fifth_definitions_answer3;
import static com.example.android.thequizzworld.R.string.fifth_definitions_answer4;
import static com.example.android.thequizzworld.R.string.fifth_definitions_question;
import static com.example.android.thequizzworld.R.string.first_definitions_answer1;
import static com.example.android.thequizzworld.R.string.first_definitions_answer2;
import static com.example.android.thequizzworld.R.string.first_definitions_answer3;
import static com.example.android.thequizzworld.R.string.first_definitions_answer4;
import static com.example.android.thequizzworld.R.string.first_definitions_question;
import static com.example.android.thequizzworld.R.string.fourth_definitions_answer1;
import static com.example.android.thequizzworld.R.string.fourth_definitions_answer2;
import static com.example.android.thequizzworld.R.string.fourth_definitions_answer3;
import static com.example.android.thequizzworld.R.string.fourth_definitions_answer4;
import static com.example.android.thequizzworld.R.string.fourth_definitions_question;
import static com.example.android.thequizzworld.R.string.ninth_definitions_answer1;
import static com.example.android.thequizzworld.R.string.ninth_definitions_answer2;
import static com.example.android.thequizzworld.R.string.ninth_definitions_answer3;
import static com.example.android.thequizzworld.R.string.ninth_definitions_answer4;
import static com.example.android.thequizzworld.R.string.ninth_definitions_question;
import static com.example.android.thequizzworld.R.string.second_definitions_answer1;
import static com.example.android.thequizzworld.R.string.second_definitions_answer2;
import static com.example.android.thequizzworld.R.string.second_definitions_answer3;
import static com.example.android.thequizzworld.R.string.second_definitions_answer4;
import static com.example.android.thequizzworld.R.string.second_definitions_question;
import static com.example.android.thequizzworld.R.string.seventh_definitions_answer1;
import static com.example.android.thequizzworld.R.string.seventh_definitions_answer2;
import static com.example.android.thequizzworld.R.string.seventh_definitions_answer3;
import static com.example.android.thequizzworld.R.string.seventh_definitions_answer4;
import static com.example.android.thequizzworld.R.string.seventh_definitions_question;
import static com.example.android.thequizzworld.R.string.sixth_definitions_answer1;
import static com.example.android.thequizzworld.R.string.sixth_definitions_question;
import static com.example.android.thequizzworld.R.string.tenth_definitions_answer1;
import static com.example.android.thequizzworld.R.string.tenth_definitions_answer2;
import static com.example.android.thequizzworld.R.string.tenth_definitions_answer3;
import static com.example.android.thequizzworld.R.string.tenth_definitions_answer4;
import static com.example.android.thequizzworld.R.string.tenth_definitions_question;
import static com.example.android.thequizzworld.R.string.third_definitions_answer1;
import static com.example.android.thequizzworld.R.string.third_definitions_answer2;
import static com.example.android.thequizzworld.R.string.third_definitions_answer3;
import static com.example.android.thequizzworld.R.string.third_definitions_answer4;
import static com.example.android.thequizzworld.R.string.third_definitions_question;
import static com.example.android.thequizzworld.R.string.your_score_is;

public class DefinitionsActivity extends AppCompatActivity {
    int currentScore = 0;
    int maximumScore = 0;

    // initial value of timer
    int decreaseOverTime = 11;

    TextView timer;
    Timer countDownTimer;
    TextView textView;
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;

    // Clicking BACK button also stops timer
    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        Intent nextQuestion = new Intent(this, TimeLimitedActivity.class);
        startActivity(nextQuestion);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_limited_quiz);

        //define first questions and answers
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(first_definitions_question);

        answer1 = (TextView) findViewById(R.id.answer1);
        answer1.setText(first_definitions_answer1);

        answer2 = (TextView) findViewById(R.id.answer2);
        answer2.setText(first_definitions_answer2);

        answer3 = (TextView) findViewById(R.id.answer3);
        answer3.setText(first_definitions_answer3);

        answer4 = (TextView) findViewById(R.id.answer4);
        answer4.setText(first_definitions_answer4);

        // start timer when this Acitivity is opened
        Timer();
        timer = (TextView) findViewById(R.id.timer);
        displayCurrentScore();
    }

    // when each question is answered, timer gets its initial value
    public void resetTimersValue() {
        decreaseOverTime = 11;
    }

    // timer
    public void Timer() {
        timer = (TextView) findViewById(R.id.timer);
        countDownTimer = new Timer();
        countDownTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                decreaseOverTime = decreaseOverTime - 1;
                runOnUiThread(new Runnable() {
                    public void run() {
                        // if timer is equal to zero, score gets updated and timer stops
                        if (decreaseOverTime == 0) {
                            timer.setText("0 s");
                            maximumScore = maximumScore + 10;
                            countDownTimer.cancel();

                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed SECOND question and answers with reset timer displayed
                            if (maximumScore == 10) {
                                displaySecondQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed THIRD question and answers with reset timer displayed
                            if (maximumScore == 20) {
                                displayThirdQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed FOURTH question and answers with reset timer displayed
                            if (maximumScore == 30) {
                                displayFourthQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed FIFTH question and answers with reset timer displayed
                            if (maximumScore == 40) {
                                displayFifthQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed SIXTH question and answers with reset timer displayed
                            if (maximumScore == 50) {
                                displaySixthQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed SEVENTH question and answers with reset timer displayed
                            if (maximumScore == 60) {
                                displaySeventhQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed EIGHTH question and answers with reset timer displayed
                            if (maximumScore == 70) {
                                displayEighthQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed NINTH question and answers with reset timer displayed
                            if (maximumScore == 80) {
                                displayNinthQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed TENTH question and answers with reset timer displayed
                            if (maximumScore == 90) {
                                displayTenthQuestion();
                            }
                            // if question is not answered, the maximumScore gets update to 10 and then code makes displayed LAST page
                            if (maximumScore == 100) {
                                viewFinalScorePage();
                            }
                            displayCurrentScore();
                            clearAllButtons();
                            resetTimersValue();
                            Timer();
                        } else {
                            timer.setText("" + decreaseOverTime + " s");
                        }
                    }
                });
            }
        }, 100, 1000);
    }

    // displays current score
    private void displayCurrentScore() {
        TextView text = (TextView) findViewById(R.id.text);
        text.setText(getString(your_score_is) + " " + currentScore + "/" + maximumScore);
    }

    // redirects to last page when quiz is finished
    private void viewFinalScorePage() {
        Intent nextQuestion = new Intent(this, timeLimitedCongratulations.class);
        nextQuestion.putExtra("passedCurrentScore", currentScore);
        nextQuestion.putExtra("passedMaximumScore", maximumScore);
        startActivity(nextQuestion);
    }

    // second question
    private void displaySecondQuestion() {
        textView.setText(second_definitions_question);
        answer1.setText(second_definitions_answer1);
        answer2.setText(second_definitions_answer2);
        answer3.setText(second_definitions_answer3);
        answer4.setText(second_definitions_answer4);
    }

    // third question
    private void displayThirdQuestion() {
        textView.setText(third_definitions_question);
        answer1.setText(third_definitions_answer1);
        answer2.setText(third_definitions_answer2);
        answer3.setText(third_definitions_answer3);
        answer4.setText(third_definitions_answer4);
    }

    // fourth question
    private void displayFourthQuestion() {
        textView.setText(fourth_definitions_question);
        answer1.setText(fourth_definitions_answer1);
        answer2.setText(fourth_definitions_answer2);
        answer3.setText(fourth_definitions_answer3);
        answer4.setText(fourth_definitions_answer4);
    }

    // fifth question
    private void displayFifthQuestion() {
        textView.setText(fifth_definitions_question);
        answer1.setText(fifth_definitions_answer1);
        answer2.setText(fifth_definitions_answer2);
        answer3.setText(fifth_definitions_answer3);
        answer4.setText(fifth_definitions_answer4);
    }

    // sixth question
    private void displaySixthQuestion() {
        textView.setText(sixth_definitions_question);
        answer1.setText(sixth_definitions_answer1);
        answer2.setText(fifth_definitions_answer2);
        answer3.setText(fifth_definitions_answer3);
        answer4.setText(fifth_definitions_answer4);
    }

    // seventh question
    private void displaySeventhQuestion() {
        textView.setText(seventh_definitions_question);
        answer1.setText(seventh_definitions_answer1);
        answer2.setText(seventh_definitions_answer2);
        answer3.setText(seventh_definitions_answer3);
        answer4.setText(seventh_definitions_answer4);
    }

    // eight question
    private void displayEighthQuestion() {
        textView.setText(eighth_definitions_question);
        answer1.setText(eighth_definitions_answer1);
        answer2.setText(eighth_definitions_answer2);
        answer3.setText(eighth_definitions_answer3);
        answer4.setText(eighth_definitions_answer4);
    }

    // ninth question
    private void displayNinthQuestion() {
        textView.setText(ninth_definitions_question);
        answer1.setText(ninth_definitions_answer1);
        answer2.setText(ninth_definitions_answer2);
        answer3.setText(ninth_definitions_answer3);
        answer4.setText(ninth_definitions_answer4);
    }

    // tenth question
    private void displayTenthQuestion() {
        textView.setText(tenth_definitions_question);
        answer1.setText(tenth_definitions_answer1);
        answer2.setText(tenth_definitions_answer2);
        answer3.setText(tenth_definitions_answer3);
        answer4.setText(tenth_definitions_answer4);
    }

    // clears button's selection (cosmetic change which doesn't influence app's functionality in case RadioButtons are not set to be invisible)
    public void clearAllButtons() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
    }

    public void onClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // first question
        if (maximumScore == 0) {
            switch (view.getId()) {
                case R.id.answer3:
                    if (checked) {
                        // correct answer
                        // add value multiplied by current time
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displaySecondQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // second question
        else if (maximumScore == 10) {
            switch (view.getId()) {
                case R.id.answer2:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displayThirdQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // third question
        else if (maximumScore == 20) {
            switch (view.getId()) {
                case R.id.answer2:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displayFourthQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // fourth question
        else if (maximumScore == 30) {
            switch (view.getId()) {
                case R.id.answer1:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displayFifthQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // fifth question
        else if (maximumScore == 40) {
            switch (view.getId()) {
                case R.id.answer3:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displaySixthQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // sixth question
        else if (maximumScore == 50) {
            switch (view.getId()) {
                case R.id.answer4:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displaySeventhQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // seventh question
        else if (maximumScore == 60) {
            switch (view.getId()) {
                case R.id.answer3:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displayEighthQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // eighth question
        else if (maximumScore == 70) {
            switch (view.getId()) {
                case R.id.answer4:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displayNinthQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // ninth question
        else if (maximumScore == 80) {
            switch (view.getId()) {
                case R.id.answer1:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays next question
            displayTenthQuestion();
        }

        // same code as in the first if within this void BUT with second questions displayed
        // tenth question
        else if (maximumScore == 90) {
            switch (view.getId()) {
                case R.id.answer1:
                    if (checked) {
                        currentScore = currentScore + decreaseOverTime;
                        break;
                    }
            }
            // adds maximum score and stops timer
            maximumScore = maximumScore + 10;
            countDownTimer.cancel();
            // displays final page
            viewFinalScorePage();
        }

        // updates score, clears buttons and resets timer
        displayCurrentScore();
        clearAllButtons();
        resetTimersValue();
        Timer();
    }
}