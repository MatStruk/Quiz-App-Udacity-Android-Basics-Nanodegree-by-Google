package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TimeLimitedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_limited);

        Button buttonRacingTracks = (Button) findViewById(R.id.buttonRacingTracks);
        buttonRacingTracks.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(TimeLimitedActivity.this, RacingTracksActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        Button buttonDefinitions = (Button) findViewById(R.id.buttonDefinitions);
        buttonDefinitions.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(TimeLimitedActivity.this, DefinitionsActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });


        Button buttonBrands = (Button) findViewById(R.id.buttonBrands);
        buttonBrands.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(TimeLimitedActivity.this, BrandsActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(TimeLimitedActivity.this, ChooseFormatActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });

    }
}
