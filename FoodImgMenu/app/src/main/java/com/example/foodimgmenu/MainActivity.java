package com.example.foodimgmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

//    private CheckBox chk1, chk2, chk3, chk4, chk5;
//    private ImageView output1, output2, output3, output4, output5;
    private CheckBox[] checkBoxes;
    private ImageView[] imageViews;
    private static final int[] checkBoxIds = { R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4, R.id.chk5 };
    private static final int[] imageViewIds = { R.id.output1, R.id.output2, R.id.output3, R.id.output4, R.id.output5 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化 CheckBox 和 ImageView 的陣列
        checkBoxes = new CheckBox[5];
        imageViews = new ImageView[5];

        // 設定 CheckBox 和 ImageView 的元件並隱藏 ImageView
        for (int i = 0; i < 5; i++) {
            checkBoxes[i] = findViewById(checkBoxIds[i]);
            imageViews[i] = findViewById(imageViewIds[i]);
            imageViews[i].setVisibility(View.GONE);

            checkBoxes[i].setOnCheckedChangeListener(this);
        }

//        chk1 = (CheckBox) findViewById(R.id.chk1);
//        chk2 = (CheckBox) findViewById(R.id.chk2);
//        chk3 = (CheckBox) findViewById(R.id.chk3);
//        chk4 = (CheckBox) findViewById(R.id.chk4);
//        chk5 = (CheckBox) findViewById(R.id.chk5);
//
//        output1 = (ImageView) findViewById(R.id.output1);
//        output2 = (ImageView) findViewById(R.id.output2);
//        output3 = (ImageView) findViewById(R.id.output3);
//        output4 = (ImageView) findViewById(R.id.output4);
//        output5 = (ImageView) findViewById(R.id.output5);
//
//        output1.setVisibility(View.GONE);
//        output2.setVisibility(View.GONE);
//        output3.setVisibility(View.GONE);
//        output4.setVisibility(View.GONE);
//        output5.setVisibility(View.GONE);
//
//        chk1.setOnCheckedChangeListener(this);
//        chk2.setOnCheckedChangeListener(this);
//        chk3.setOnCheckedChangeListener(this);
//        chk4.setOnCheckedChangeListener(this);
//        chk5.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        for (int i = 0; i < 5; i++) {
            if (buttonView.getId() == checkBoxIds[i]) {
                toggleVisibility(isChecked, imageViews[i]);
                break;
            }
        }
//        int id = buttonView.getId();
//        if(id == R.id.chk1) {
//            toggleVisibility(isChecked, output1);
//        }
//        if(id == R.id.chk2) {
//            toggleVisibility(isChecked, output2);
//        }
//        if(id == R.id.chk3) {
//            toggleVisibility(isChecked, output3);
//        }
//        if(id == R.id.chk4) {
//            toggleVisibility(isChecked, output4);
//        }
//        if(id == R.id.chk5) {
//            toggleVisibility(isChecked, output5);
//        }
    }
    private void toggleVisibility(boolean isChecked, ImageView imageView) {
        imageView.setVisibility(isChecked ? View.VISIBLE : View.GONE);
    }
}