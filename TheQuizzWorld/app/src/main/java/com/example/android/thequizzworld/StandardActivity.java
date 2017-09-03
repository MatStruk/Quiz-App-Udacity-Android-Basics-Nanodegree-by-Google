package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.android.thequizzworld.R.id.buttonBasic;

public class StandardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        Button buttonRacingTracks = (Button) findViewById(R.id.buttonModels);
        buttonRacingTracks.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(StandardActivity.this, CarModelsActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        Button buttonDefinitions = (Button) findViewById(R.id.buttonOrigins);
        buttonDefinitions.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(StandardActivity.this, OriginsActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });


        Button buttonBrands = (Button) findViewById(R.id.buttonRecognizeCar);
        buttonBrands.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(StandardActivity.this, RecognizeCarActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });


        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(StandardActivity.this, ChooseFormatActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });
    }
}
