package com.example.lab2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lab2android.utility.SaveLoad;

public class MainActivity extends AppCompatActivity implements ContentFragment.OnFragmentSendDataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String selectedItem) {
        BlankFragment fragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (fragment != null)
            fragment.setSelectedItem(selectedItem);
            SaveLoad.saveData(findViewById(android.R.id.content).getRootView(), selectedItem);
    }

}