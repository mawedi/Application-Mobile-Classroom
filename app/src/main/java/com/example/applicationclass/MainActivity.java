package com.example.applicationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView seekBarText, output;
    RadioButton yesResponse;
    RadioButton noResponse;
    Button submitButton;
    EditText glycemicValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the text to update it
        seekBar = findViewById(R.id.scroll_bar);
        seekBarText = findViewById(R.id.scroll_bar_value);
        yesResponse = findViewById(R.id.yes_response);
        noResponse = findViewById(R.id.no_response);
        submitButton = findViewById(R.id.submit_button);
        glycemicValue = findViewById(R.id.glycemic_value);
        output = findViewById(R.id.tvReponse);

        seekBar.setProgress(18);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = seekBar.getProgress();
                seekBarText.setText(Integer.toString(value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit(v);
            }
        });
    }

    private void onSubmit(View view) {
        // Getting the data
        Integer age = seekBar.getProgress();
        Boolean fastPerson = yesResponse.isChecked();
        Boolean notFastPerson = noResponse.isChecked();
        String glycemicInput = glycemicValue.getText().toString();

        // Checking the data
        if ((!fastPerson) && (!notFastPerson)) {
            output.setText("Missing data!");
            output.setTextColor(Color.RED);

        }

        if (glycemicInput.equals("")) {
            output.setText("Missing data!");
            output.setTextColor(Color.RED);

        } else {
            Double glycemicValue = Double.valueOf(glycemicInput);

            if (notFastPerson && (age < 13) && (age > 5) && (glycemicValue >= 5) && (glycemicValue <= 10)) {
                output.setText("blood sugar is normal");
                output.setTextColor(Color.BLACK);

            } else if (notFastPerson && (age < 6) && (glycemicValue >= 5) && (glycemicValue <= 10)) {
                output.setText("blood sugar is normal");
                output.setTextColor(Color.BLACK);

            } else if (notFastPerson && (age >= 13) && (glycemicValue <= 7.2) && (glycemicValue >= 5)) {
                output.setText("blood sugar is normal");
                output.setTextColor(Color.BLACK);

            } else if (fastPerson && (glycemicValue < 10.5)) {
                output.setText("blood sugar is normal");
                output.setTextColor(Color.BLACK);

            } else if (glycemicValue < 5){
                output.setText("blood sugar level is too low");
                output.setTextColor(Color.BLACK);

            } else if (glycemicValue >= 10.5) {
                output.setText("blood sugar level is too high");
                output.setTextColor(Color.BLACK);

            }
        }


    }
}