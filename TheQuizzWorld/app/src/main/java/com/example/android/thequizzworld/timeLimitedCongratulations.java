package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;

import static com.example.android.thequizzworld.R.string.high_score_at_the_end;
import static com.example.android.thequizzworld.R.string.low_score_at_the_end;
import static com.example.android.thequizzworld.R.string.medium_score_at_the_end;

public class timeLimitedCongratulations extends AppCompatActivity {
    int currentScore = 0;
    int maximumScore = 0;
    Timer countDownTimer;

    @Override
    public void onBackPressed() {
        Intent nextQuestion = new Intent(this, MainActivity.class);
        startActivity(nextQuestion);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_limited_congratulations);

        Button buttonMainMenu = (Button) findViewById(R.id.buttonMainMenu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(timeLimitedCongratulations.this, MainActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        Button buttonPlayTimeLimited = (Button) findViewById(R.id.buttonPlayTimeLimited);
        buttonPlayTimeLimited.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(timeLimitedCongratulations.this, TimeLimitedActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });


        Button buttonPlayStandard = (Button) findViewById(R.id.buttonPlayStandard);
        buttonPlayStandard.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(timeLimitedCongratulations.this, StandardActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });


        Intent nextQuestion = getIntent();
        currentScore = nextQuestion.getIntExtra("passedCurrentScore", 0);
        maximumScore = nextQuestion.getIntExtra("passedMaximumScore", 0);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(currentScore + "/" + maximumScore);

        ImageView finalImage = (ImageView) findViewById(R.id.finalImage);

        TextView congratulations = (TextView) findViewById(R.id.congratulations);

        if (currentScore > 65 && currentScore < 101) {
            congratulations.setText(high_score_at_the_end);
            finalImage.setImageResource(R.drawable.ferrari);
        }
        if (currentScore > 39 && currentScore < 66) {
            congratulations.setText(medium_score_at_the_end);
            finalImage.setImageResource(R.drawable.mercedes);
        }
        if (currentScore > -1 && currentScore < 40) {
            congratulations.setText(low_score_at_the_end);
            finalImage.setImageResource(R.drawable.fiat);
        }

        if (maximumScore < 100) {
            if (currentScore > 5 && currentScore < 11) {
                congratulations.setText(high_score_at_the_end);
                finalImage.setImageResource(R.drawable.ferrari);
            }
            if (currentScore > 3 && currentScore < 6) {
                congratulations.setText(medium_score_at_the_end);
                finalImage.setImageResource(R.drawable.mercedes);
            }
            if (currentScore > -1 && currentScore < 4) {
                congratulations.setText(low_score_at_the_end);
                finalImage.setImageResource(R.drawable.fiat);
            }
        }
    }
}

