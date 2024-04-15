package com.example.applicationclass.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationclass.R;
import com.example.applicationclass.controller.Controller;
import com.example.applicationclass.model.Patient;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView seekBarText, output;
    RadioButton yesResponse;
    RadioButton noResponse;
    Button submitButton;
    EditText glycemicValue;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the text to update it
        init();

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

        // Checking if the glycemic input is empty to print missing data to the user
        if (glycemicInput.equals("")) {
            output.setText("Missing data!");
            output.setTextColor(Color.RED);

            // Printing a result to the user after analyzing the input.
        } else {
            Double glycemicValue = Double.valueOf(glycemicInput);
            controller.createPatient(age, glycemicValue, fastPerson);

            Intent intent = new Intent(MainActivity.this, ConsultActivity.class);
            intent.putExtra("result", controller.getResult());
            startActivity(intent);
        }

    }

    public void init() {
        controller = Controller.getInstance();

        seekBar = findViewById(R.id.scroll_bar);
        seekBarText = findViewById(R.id.scroll_bar_value);
        yesResponse = findViewById(R.id.yes_response);
        noResponse = findViewById(R.id.no_response);
        submitButton = findViewById(R.id.submit_button);
        glycemicValue = findViewById(R.id.glycemic_value);
        output = findViewById(R.id.tvReponse);

        // Initializing the progress bar on 18
        seekBar.setProgress(18);
    }

}