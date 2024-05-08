package com.example.ticketpurchase;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, TextWatcher {



    enum gender { Boy, girl }
    enum identity { Adult, Child, Student }
    private String gender = "男性";
    private String identity = "成人";
    private int Number = 1;
    private int money = 500;
    private String resultString = null;
    RadioGroup RdGroup, RdGroup_2;
    EditText NumSheets;
    TextView result;
    NumberPicker numberPicker;
    Button btnPurchase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RdGroup = (RadioGroup) findViewById(R.id.RdGroup);
        RdGroup_2 = (RadioGroup) findViewById(R.id.RdGroup_2);
        NumSheets = (EditText) findViewById(R.id.NumSheets);
        result = (TextView) findViewById(R.id.result);
        btnPurchase = (Button) findViewById(R.id.btnPurchase);

        RdGroup.check(R.id.genderBoy);
        RdGroup_2.check(R.id.rdAdult);

        RdGroup.setOnCheckedChangeListener(this);
        RdGroup_2.setOnCheckedChangeListener(this);
        NumSheets.addTextChangedListener(this);
        btnPurchase.setOnClickListener(this);

        money = returnMoney(identity) * Number;
        resultString = String.format("%s\n%s\n%d 張\n%d 元", gender, identity, Number, money);
        result.setText(resultString);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.genderBoy) {
            gender = "男性";
        } else if (checkedId == R.id.genderGirl) {
            gender = "女性";
        } else if (checkedId == R.id.rdAdult) {
            identity = "成人";
            money = returnMoney(identity) * Number;
        } else if (checkedId == R.id.rdChild) {
            identity = "兒童";
            money = returnMoney(identity) * Number;
        } else if (checkedId == R.id.rdStudent) {
            identity = "學生";
            money = returnMoney(identity) * Number;
        }
        resultString = String.format("%s\n%s\n%d 張\n%d 元", gender, identity, Number, money);
        result.setText(resultString);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Number =  Integer.parseInt(NumSheets.getText().toString());
        money = returnMoney(identity) * Number;
        resultString = String.format("%s\n%s\n%d 張\n%d 元", gender, identity, Number, money);
        result.setText(resultString);
    }

    public int returnMoney(String profession) {
        if(profession.equals("成人")) {
            return 500;
        } else if(profession.equals("兒童")) {
            return 250;
        } else {
            return 400;
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity_2.class);
        intent.putExtra("resultString", resultString);
        startActivity(intent);
    }
}