package com.example.applicationclass.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.applicationclass.R;

public class ConsultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        TextView response = findViewById(R.id.consult_result);
        Button back = findViewById(R.id.back);

        // Setting the view of the result
        String result = getIntent().getStringExtra("result");
        response.setText(result);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}