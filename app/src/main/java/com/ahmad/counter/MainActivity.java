package com.ahmad.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView numberDisplay;
    Button buttonUp, buttonDown;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberDisplay = findViewById(R.id.numberDisplay);
        buttonUp = findViewById(R.id.buttonUp);
        buttonDown = findViewById(R.id.buttonDown);

        buttonUp.setOnClickListener(this);
        buttonDown.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonUp){
            score++;
            numberDisplay.setText(String.valueOf(score));
            numberDisplay.setTextColor(Color.GREEN);
        }else {
            score--;
            numberDisplay.setText(String.valueOf(score));
            numberDisplay.setTextColor(Color.RED);
        }
    }
}