package com.example.spandlv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        AdapterView.OnItemClickListener, MenuItem.OnMenuItemClickListener {
    public ArrayAdapter<String> adapter;
    public Spinner spinner;
    public ListView listView;
    public TextView txtmain, txtdrink, txtattached;
    public String selectedItem;
    public int selectedId;
    public String[] optionField;
    public MenuItem send, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.listView);

        txtmain = (TextView) findViewById(R.id.txtmain);
        txtdrink = (TextView) findViewById(R.id.txtdrink);
        txtattached = (TextView) findViewById(R.id.txtattached);

        spinner.setOnItemSelectedListener(this);
        listView.setOnItemClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        send = (MenuItem) menu.findItem(R.id.send1);
        cancel = (MenuItem) menu.findItem(R.id.send2);

        send.setOnMenuItemClickListener(this);
        cancel.setOnMenuItemClickListener(this);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int out = (i == 0) ? R.array.main : (i == 1) ? R.array.drink : (i == 2) ? R.array.attached : 0;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(out));
        listView.setAdapter(adapter);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectedItem = listView.getItemAtPosition(i).toString();
        optionField = getResources().getStringArray(R.array.choice);
        if(spinner.getSelectedItemId() == 0) {
            txtmain.setText(String.format("%s : %s", optionField[0], selectedItem));
        } else if(spinner.getSelectedItemId() == 1) {
            txtdrink.setText(String.format("%s : %s", optionField[1], selectedItem));
        }else if(spinner.getSelectedItemId() == 2) {
            txtattached.setText(String.format("%s : %s", optionField[2], selectedItem));
        }
    }
    @Override
    public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
        selectedId = menuItem.getItemId();
        if(selectedId == R.id.send1){
            Log.v("description", "Nothing Used");
        } else if(selectedId == R.id.send2) {
            txtmain.setText(getResources().getString(R.string.main_init));
            txtdrink.setText(getResources().getString(R.string.drink_init));
            txtattached.setText(getResources().getString(R.string.attached_init));
        }

        return false;
    }
}