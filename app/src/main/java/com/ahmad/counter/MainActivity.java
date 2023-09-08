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
        String currentScore = numberDisplay.getText().toString();
        int currentScoreInt = Integer.valueOf(currentScore);
        if (v.getId() == R.id.buttonUp){
            score = currentScoreInt +1;
            numberDisplay.setText(String.valueOf(score));
            numberDisplay.setTextColor(Color.GREEN);
        }else {
            score = currentScoreInt -1;
            numberDisplay.setText(String.valueOf(score));
            numberDisplay.setTextColor(Color.RED);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("countSave", String.valueOf(numberDisplay.getText()));
        outState.putInt("colourSave", numberDisplay.getCurrentTextColor());

    }

    @Override
    public  void onRestoreInstanceState(Bundle mySavedState){
        super.onRestoreInstanceState(mySavedState);

        if (mySavedState != null){
            String count = mySavedState.getString("countSave");
            int colour = mySavedState.getInt("colourSave");
            if (count != null){
                numberDisplay.setText(count);
                numberDisplay.setTextColor(colour);
            }
        }
    }
}