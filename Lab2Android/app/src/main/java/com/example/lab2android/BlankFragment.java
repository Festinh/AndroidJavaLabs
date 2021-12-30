package com.example.lab2android;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        super(R.layout.fragment_blank);
    }

    public void setSelectedItem(String selectedItem) {
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(selectedItem);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
