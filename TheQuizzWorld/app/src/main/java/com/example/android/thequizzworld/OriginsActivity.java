package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.thequizzworld.R.string.eighth_origins_answer1;
import static com.example.android.thequizzworld.R.string.eighth_origins_answer2;
import static com.example.android.thequizzworld.R.string.eighth_origins_answer3;
import static com.example.android.thequizzworld.R.string.eighth_origins_answer4;
import static com.example.android.thequizzworld.R.string.eighth_origins_explanation;
import static com.example.android.thequizzworld.R.string.eighth_origins_question;
import static com.example.android.thequizzworld.R.string.fifth_origins_answer1;
import static com.example.android.thequizzworld.R.string.fifth_origins_answer2;
import static com.example.android.thequizzworld.R.string.fifth_origins_answer3;
import static com.example.android.thequizzworld.R.string.fifth_origins_answer4;
import static com.example.android.thequizzworld.R.string.fifth_origins_explanation;
import static com.example.android.thequizzworld.R.string.fifth_origins_question;
import static com.example.android.thequizzworld.R.string.first_origins_answer1;
import static com.example.android.thequizzworld.R.string.first_origins_answer2;
import static com.example.android.thequizzworld.R.string.first_origins_answer3;
import static com.example.android.thequizzworld.R.string.first_origins_answer4;
import static com.example.android.thequizzworld.R.string.first_origins_explanation;
import static com.example.android.thequizzworld.R.string.first_origins_question;
import static com.example.android.thequizzworld.R.string.fourth_origins_answer1;
import static com.example.android.thequizzworld.R.string.fourth_origins_answer2;
import static com.example.android.thequizzworld.R.string.fourth_origins_answer3;
import static com.example.android.thequizzworld.R.string.fourth_origins_answer4;
import static com.example.android.thequizzworld.R.string.fourth_origins_explanation;
import static com.example.android.thequizzworld.R.string.fourth_origins_question;
import static com.example.android.thequizzworld.R.string.ninth_origins_answer1;
import static com.example.android.thequizzworld.R.string.ninth_origins_answer2;
import static com.example.android.thequizzworld.R.string.ninth_origins_answer3;
import static com.example.android.thequizzworld.R.string.ninth_origins_answer4;
import static com.example.android.thequizzworld.R.string.ninth_origins_explanation;
import static com.example.android.thequizzworld.R.string.ninth_origins_question;
import static com.example.android.thequizzworld.R.string.second_origins_answer1;
import static com.example.android.thequizzworld.R.string.second_origins_answer2;
import static com.example.android.thequizzworld.R.string.second_origins_answer3;
import static com.example.android.thequizzworld.R.string.second_origins_answer4;
import static com.example.android.thequizzworld.R.string.second_origins_explanation;
import static com.example.android.thequizzworld.R.string.second_origins_question;
import static com.example.android.thequizzworld.R.string.seventh_origins_answer1;
import static com.example.android.thequizzworld.R.string.seventh_origins_answer2;
import static com.example.android.thequizzworld.R.string.seventh_origins_answer3;
import static com.example.android.thequizzworld.R.string.seventh_origins_answer4;
import static com.example.android.thequizzworld.R.string.seventh_origins_explanation;
import static com.example.android.thequizzworld.R.string.seventh_origins_question;
import static com.example.android.thequizzworld.R.string.sixth_origins_answer1;
import static com.example.android.thequizzworld.R.string.sixth_origins_answer2;
import static com.example.android.thequizzworld.R.string.sixth_origins_answer3;
import static com.example.android.thequizzworld.R.string.sixth_origins_answer4;
import static com.example.android.thequizzworld.R.string.sixth_origins_explanation;
import static com.example.android.thequizzworld.R.string.sixth_origins_question;
import static com.example.android.thequizzworld.R.string.tenth_origins_answer1;
import static com.example.android.thequizzworld.R.string.tenth_origins_answer2;
import static com.example.android.thequizzworld.R.string.tenth_origins_answer3;
import static com.example.android.thequizzworld.R.string.tenth_origins_answer4;
import static com.example.android.thequizzworld.R.string.tenth_origins_explanation;
import static com.example.android.thequizzworld.R.string.tenth_origins_question;
import static com.example.android.thequizzworld.R.string.third_origins_answer1;
import static com.example.android.thequizzworld.R.string.third_origins_answer2;
import static com.example.android.thequizzworld.R.string.third_origins_answer3;
import static com.example.android.thequizzworld.R.string.third_origins_answer4;
import static com.example.android.thequizzworld.R.string.third_origins_explanation;
import static com.example.android.thequizzworld.R.string.third_origins_question;
import static com.example.android.thequizzworld.R.string.your_score_is;

public class OriginsActivity extends AppCompatActivity {
    int currentScore = 0;
    int maximumScore = 0;
    TextView textView;
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_quiz);

        //define first questions and answers
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(first_origins_question);

        answer1 = (TextView) findViewById(R.id.answer1);
        answer1.setText(first_origins_answer1);

        answer2 = (TextView) findViewById(R.id.answer2);
        answer2.setText(first_origins_answer2);

        answer3 = (TextView) findViewById(R.id.answer3);
        answer3.setText(first_origins_answer3);

        answer4 = (TextView) findViewById(R.id.answer4);
        answer4.setText(first_origins_answer4);
        displayCurrentScore();
    }

    // update score
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

    // MULTIPLE QUESTIONS
    // second question
    private void displaySecondQuestion() {
        textView.setText(second_origins_question);
        answer1.setText(second_origins_answer1);
        answer2.setText(second_origins_answer2);
        answer3.setText(second_origins_answer3);
        answer4.setText(second_origins_answer4);
    }

    // third question
    private void displayThirdQuestion() {
        textView.setText(third_origins_question);
        answer1.setText(third_origins_answer1);
        answer2.setText(third_origins_answer2);
        answer3.setText(third_origins_answer3);
        answer4.setText(third_origins_answer4);

    }

    // fourth question
    private void displayFourthQuestion() {
        textView.setText(fourth_origins_question);
        answer1.setText(fourth_origins_answer1);
        answer2.setText(fourth_origins_answer2);
        answer3.setText(fourth_origins_answer3);
        answer4.setText(fourth_origins_answer4);

    }

    // fifth question
    private void displayFifthQuestion() {
        textView.setText(fifth_origins_question);
        answer1.setText(fifth_origins_answer1);
        answer2.setText(fifth_origins_answer2);
        answer3.setText(fifth_origins_answer3);
        answer4.setText(fifth_origins_answer4);

    }

    // sixth question
    private void displaySixthQuestion() {
        textView.setText(sixth_origins_question);
        answer1.setText(sixth_origins_answer1);
        answer2.setText(sixth_origins_answer2);
        answer3.setText(sixth_origins_answer3);
        answer4.setText(sixth_origins_answer4);

    }

    // seventh question
    private void displaySeventhQuestion() {
        textView.setText(seventh_origins_question);
        answer1.setText(seventh_origins_answer1);
        answer2.setText(seventh_origins_answer2);
        answer3.setText(seventh_origins_answer3);
        answer4.setText(seventh_origins_answer4);

    }

    // eighth question
    private void displayEighthQuestion() {
        textView.setText(eighth_origins_question);
        answer1.setText(eighth_origins_answer1);
        answer2.setText(eighth_origins_answer2);
        answer3.setText(eighth_origins_answer3);
        answer4.setText(eighth_origins_answer4);

    }

    // ninth question
    private void displayNinthQuestion() {
        textView.setText(ninth_origins_question);
        answer1.setText(ninth_origins_answer1);
        answer2.setText(ninth_origins_answer2);
        answer3.setText(ninth_origins_answer3);
        answer4.setText(ninth_origins_answer4);

    }

    // tenth question
    private void displayTenthQuestion() {
        textView.setText(tenth_origins_question);
        answer1.setText(tenth_origins_answer1);
        answer2.setText(tenth_origins_answer2);
        answer3.setText(tenth_origins_answer3);
        answer4.setText(tenth_origins_answer4);

    }

    // onClick load next question, update score and toast proper answer
    protected void updateCurrentQuestionAndDisplayNewOne(View view) {
        int calculatingCorrectAnswer = 0;
        // attach CheckBoxes to appropriate boxes
        CheckBox answer1 = (CheckBox) findViewById(R.id.answer1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.answer2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.answer3);
        CheckBox answer4 = (CheckBox) findViewById(R.id.answer4);

        // displaying first question
        if (maximumScore == 0) {
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 2) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, first_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads second question (with answers)
            displaySecondQuestion();
        }

        // displaying second question
        else if (maximumScore == 1) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 2) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, second_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads third question (with answers)
            displayThirdQuestion();
        }

        // displaying third question
        else if (maximumScore == 2) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 2) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, third_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads fourth question (with answers)
            displayFourthQuestion();
        }

        // displaying fourth question
        else if (maximumScore == 3) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 4) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, fourth_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads fifth question (with answers)
            displayFifthQuestion();
        }

        // displaying fifth question
        else if (maximumScore == 4) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 3) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            }
            else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, fifth_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads sixth question (with answers)
            displaySixthQuestion();
        }

        // displaying sixth question
        else if (maximumScore == 5) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 3) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            }
            else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, sixth_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads seventh question (with answers)
            displaySeventhQuestion();
        }

        // displaying seventh question
        else if (maximumScore == 6) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 1) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            }
            else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, seventh_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads eighth question (with answers)
            displayEighthQuestion();
        }

        // displaying eighth question
        else if (maximumScore == 7) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 2) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            }
            else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, eighth_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads ninth question (with answers)
            displayNinthQuestion();
        }

        // displaying ninth question
        else if (maximumScore == 8) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 2) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            }
            else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, ninth_origins_explanation, Toast.LENGTH_LONG).show();
            }
            // loads tenth question (with answers)
            displayTenthQuestion();
        }

        // displaying tenth question
        else if (maximumScore == 9) {
            // resets value
            calculatingCorrectAnswer = 0;
            // back-end values not visible to user. These help calculate correct answer
            if (answer1.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer2.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer - 1;
            }
            if (answer3.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            if (answer4.isChecked()) {
                calculatingCorrectAnswer = calculatingCorrectAnswer + 1;
            }
            // if value is 20, then answer is correct
            if (calculatingCorrectAnswer == 3) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            }
            else {
                maximumScore = maximumScore + 1;
                // displays correct answer
                Toast.makeText(this, tenth_origins_explanation, Toast.LENGTH_LONG).show();
            }
            //redirects to final page
            viewFinalScorePage();
        }
        // update score
        displayCurrentScore();
        // uncheck each CheckBox
        answer1.setChecked(false);
        answer2.setChecked(false);
        answer3.setChecked(false);
        answer4.setChecked(false);
    }
}
