package com.example.android.thequizzworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAbout = (Button) findViewById(R.id.buttonPlay);
        buttonAbout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, ChooseFormatActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        Button buttonRules = (Button) findViewById(R.id.buttonRules);
        buttonRules.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, RulesActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });


    }
}