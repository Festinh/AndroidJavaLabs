package com.example.lab1android;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private CheckBox bosch;
    private CheckBox peller;
    private CheckBox uah0100;
    private CheckBox uah100300;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        bosch = findViewById(R.id.checkBox);
        peller = findViewById(R.id.checkBox2);
        uah0100 = findViewById(R.id.checkBox3);
        uah100300 = findViewById(R.id.checkBox4);
        textView = findViewById(R.id.textView);
    }

    public void functionOK(View view) {
        String string = "";
        if (bosch.isChecked()) {
            string += "Bosch ";
        }
        if (peller.isChecked()) {
            string += "Peller ";
        } else {
            if (!bosch.isChecked()) {
                Toast.makeText(getApplicationContext(), "Виробник не обраний", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if (uah0100.isChecked()) {
            if (uah100300.isChecked()) {
                string += "0 - 300 грн ";
            } else {
                string += "0 - 100 грн ";
            }
        } else if (uah100300.isChecked()) {
            string += "100 - 300 грн ";
        } else {
            Toast.makeText(getApplicationContext(), "Ціна не обрана", Toast.LENGTH_SHORT).show();
            return;
        }

        string += spinner.getSelectedItem().toString();
        textView.setText(string);

    }
}