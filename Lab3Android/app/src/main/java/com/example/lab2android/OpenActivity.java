package com.example.lab2android;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2android.utility.SaveLoad;

public class OpenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(SaveLoad.loadText(this));
    }
}
