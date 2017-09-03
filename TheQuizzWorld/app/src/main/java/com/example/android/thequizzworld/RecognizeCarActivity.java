package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.thequizzworld.R.string.eighth_recognize_explanation;
import static com.example.android.thequizzworld.R.string.eighth_recognize_question;
import static com.example.android.thequizzworld.R.string.fifth_recognize_explanation;
import static com.example.android.thequizzworld.R.string.fifth_recognize_question;
import static com.example.android.thequizzworld.R.string.first_recognize_explanation;
import static com.example.android.thequizzworld.R.string.fourth_recognize_explanation;
import static com.example.android.thequizzworld.R.string.fourth_recognize_question;
import static com.example.android.thequizzworld.R.string.ninth_recognize_explanation;
import static com.example.android.thequizzworld.R.string.ninth_recognize_question;
import static com.example.android.thequizzworld.R.string.second_recognize_explanation;
import static com.example.android.thequizzworld.R.string.second_recognize_question;
import static com.example.android.thequizzworld.R.string.seventh_recognize_explanation;
import static com.example.android.thequizzworld.R.string.seventh_recognize_question;
import static com.example.android.thequizzworld.R.string.sixth_recognize_explanation;
import static com.example.android.thequizzworld.R.string.sixth_recognize_question;
import static com.example.android.thequizzworld.R.string.tenth_recognize_explanation;
import static com.example.android.thequizzworld.R.string.tenth_recognize_question;
import static com.example.android.thequizzworld.R.string.third_recognize_explanation;
import static com.example.android.thequizzworld.R.string.third_recognize_question;
import static com.example.android.thequizzworld.R.string.your_score_is;

public class RecognizeCarActivity extends AppCompatActivity {
    int currentScore = 0;
    int maximumScore = 0;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognize_car);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        // don't show keyboard when activity opens
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
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
        textView.setText(second_recognize_question);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.kiastinger);
    }

    // third question
    private void displayThirdQuestion() {
        textView.setText(third_recognize_question);
        imageView.setImageResource(R.drawable.renaulttalisman);
    }

    // fourth question
    private void displayFourthQuestion() {
        textView.setText(fourth_recognize_question);
        imageView.setImageResource(R.drawable.alfastelvio);
    }

    // fifth question
    private void displayFifthQuestion() {
        textView.setText(fifth_recognize_question);
        imageView.setImageResource(R.drawable.alpinea110);
    }

    // sixth question
    private void displaySixthQuestion() {
        textView.setText(sixth_recognize_question);
        imageView.setImageResource(R.drawable.ferrarilaferrari);
    }

    // seventh question
    private void displaySeventhQuestion() {
        textView.setText(seventh_recognize_question);
        imageView.setImageResource(R.drawable.porschepanamera);
    }

    // eighth question
    private void displayEighthQuestion() {
        textView.setText(eighth_recognize_question);
        imageView.setImageResource(R.drawable.bmwi8);
    }

    // ninth question
    private void displayNinthQuestion() {
        textView.setText(ninth_recognize_question);
        imageView.setImageResource(R.drawable.bugattichiron);
    }

    // tenth question
    private void displayTenthQuestion() {
        textView.setText(tenth_recognize_question);
        imageView.setImageResource(R.drawable.lamborghinihuracanperformante);
    }

    // onlcick method which updates current and maximum score and displays next questions
    protected void updateCurrentQuestionAndDisplayNewOne(View v) {
        EditText writeAnswer = (EditText) findViewById(R.id.writeAnswer);
        String name = writeAnswer.getText().toString();

        // first question
        if (maximumScore == 0) {

            if (name.contains("E93")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("e93")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, first_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displaySecondQuestion();
            writeAnswer.setText("");
        }

        // second question
        else if (maximumScore == 1) {

            if (name.contains("Stinger")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("stinger")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, second_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displayThirdQuestion();
            writeAnswer.setText("");
        }

        // third question
        else if (maximumScore == 2) {

            if (name.contains("Talisman")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("talisman")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, third_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displayFourthQuestion();
            writeAnswer.setText("");
        }

        // fourth question
        else if (maximumScore == 3) {

            if (name.contains("Stelvio")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("stelvio")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, fourth_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displayFifthQuestion();
            writeAnswer.setText("");
        }

        // fifth question
        else if (maximumScore == 4) {

            if (name.contains("Alpine")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("alpine")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, fifth_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displaySixthQuestion();
            writeAnswer.setText("");
        }

        // sixth question
        else if (maximumScore == 5) {

            if (name.contains("LaFerrari")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("laferrari")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("Laferrari")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, sixth_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displaySeventhQuestion();
            writeAnswer.setText("");
        }

        // seventh question
        else if (maximumScore == 6) {

            if (name.contains("Panamera")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("panamera")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, seventh_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displayEighthQuestion();
            writeAnswer.setText("");
        }

        // eighth question
        else if (maximumScore == 7) {

            if (name.contains("i8")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("I8")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, eighth_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displayNinthQuestion();
            writeAnswer.setText("");
        }

        // ninth question
        else if (maximumScore == 8) {

            if (name.contains("Chiron")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("chiron")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, ninth_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            displayTenthQuestion();
            writeAnswer.setText("");
        }

        // tenth question
        else if (maximumScore == 9) {

            if (name.contains("Performante")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else if (name.contains("performante")) {
                currentScore = currentScore + 1;
                maximumScore = maximumScore + 1;
            } else {
                maximumScore = maximumScore + 1;
                // if wrong answer selected, display correct answer
                Toast.makeText(this, tenth_recognize_explanation, Toast.LENGTH_LONG).show();
            }
            displayCurrentScore();
            writeAnswer.setText("");
            viewFinalScorePage();
        }
    }

}
