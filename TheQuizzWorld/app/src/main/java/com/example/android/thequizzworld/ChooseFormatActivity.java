package com.example.android.thequizzworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ChooseFormatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_format);

        Button buttonTimeLimited = (Button) findViewById(R.id.buttonLimitedTime);
        buttonTimeLimited.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(ChooseFormatActivity.this, TimeLimitedActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });


        Button buttonBasic = (Button) findViewById(R.id.buttonBasic);
        buttonBasic.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(ChooseFormatActivity.this, StandardActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(ChooseFormatActivity.this, MainActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });
    }
}
