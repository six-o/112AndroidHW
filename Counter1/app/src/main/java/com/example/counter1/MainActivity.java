package com.example.counter1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view) {
        int counter;
        TextView value = (TextView) findViewById(R.id.textView);
        counter = Integer.parseInt(value.getText().toString());
        counter++;
        value.setText(Integer.toString(counter));
    }

    public void button2_Click(View view) {
        TextView value = (TextView) findViewById(R.id.textView);
        value.setText(R.string.initial_value);
    }

    public void button3_Click(View view) {
        int counter;
        TextView value = (TextView) findViewById(R.id.textView);
        counter = Integer.parseInt(value.getText().toString());
        if(counter > 0){
            counter--;
        }
        value.setText(Integer.toString(counter));
    }
}