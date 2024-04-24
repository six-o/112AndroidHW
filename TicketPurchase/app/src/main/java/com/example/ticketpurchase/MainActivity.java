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

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, NumberPicker.OnValueChangeListener, View.OnClickListener {

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
        numberPicker = (NumberPicker) findViewById(R.id.numpick);
        result = (TextView) findViewById(R.id.result);
        btnPurchase = (Button) findViewById(R.id.btnPurchase);

        RdGroup.check(R.id.genderBoy);
        RdGroup_2.check(R.id.rdAdult);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(1);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        RdGroup.setOnCheckedChangeListener(this);
        RdGroup_2.setOnCheckedChangeListener(this);
        numberPicker.setOnValueChangedListener(this);
        btnPurchase.setOnClickListener(this);
        money = returnMoney(identity) * Number;
        resultString = String.format("%s\n%s\n%d 張\n%d 元", gender, identity, Number, money);
        result.setText(resultString);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.genderBoy:
                gender = "男性";
                break;
            case R.id.genderGirl:
                gender = "女性";
                break;
            case R.id.rdAdult:
                identity = "成人";
                money = returnMoney(identity) * Number;
                break;
            case R.id.rdChild:
                identity = "兒童";
                money = returnMoney(identity) * Number;
                break;
            case R.id.rdStudent:
                identity = "學生";
                money = returnMoney(identity) * Number;
                break;
        }
        resultString = String.format("%s\n%s\n%d 張\n%d 元", gender, identity, Number, money);
        result.setText(resultString);
    }
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Number =  newVal;
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