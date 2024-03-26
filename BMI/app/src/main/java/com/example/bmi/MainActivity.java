package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCal = (Button) findViewById(R.id.btnCal);
        Button btncls = (Button) findViewById(R.id.btncls);
        textView = (TextView) findViewById(R.id.lblOutput);

        textView.setTextSize(36);
        btnCal.setOnClickListener(this);
        btncls.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText editHeight = (EditText) findViewById(R.id.editHeight);
        EditText editWeight = (EditText) findViewById(R.id.editWeight);
        if(view.getId() == R.id.btnCal) {
            double height = Double.parseDouble(editHeight.getText().toString());
            double weight = Double.parseDouble(editWeight.getText().toString());
            double bmi = weight / Math.pow(height/100.0, 2);
            if(bmi >= 24) {
                textView.setTextColor(Color.RED);
            } else if(bmi <= 18.5) {
                textView.setTextColor(Color.BLUE);
            } else {
                textView.setTextColor(Color.GREEN);
            }
            textView.setText(String.format("%.2f", bmi));
        } else {
            editHeight.setText("0");
            editWeight.setText("0");
            textView.setText("0");
        }
    }
}