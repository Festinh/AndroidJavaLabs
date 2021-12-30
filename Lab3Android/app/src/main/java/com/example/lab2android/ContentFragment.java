package com.example.lab2android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2android.utility.SaveLoad;

public class ContentFragment extends Fragment {

    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    public ContentFragment() {
        super(R.layout.fragment_content);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinner = view.findViewById(R.id.spinner);
        CheckBox bosch = view.findViewById(R.id.checkBox);
        CheckBox peller = view.findViewById(R.id.checkBox2);
        CheckBox uah0100 = view.findViewById(R.id.checkBox3);
        CheckBox uah100300 = view.findViewById(R.id.checkBox4);
        final Button buttonOk = view.findViewById(R.id.button);
        final Button buttonClear = view.findViewById(R.id.button3);
        final Button buttonOpen = view.findViewById(R.id.button2);

        buttonOk.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            String string = "";
                                            if (bosch.isChecked()) {
                                                string += "Bosch ";
                                            }
                                            if (peller.isChecked()) {
                                                string += "Peller ";
                                            } else {
                                                if (!bosch.isChecked()) {
                                                    Toast.makeText(view.getContext(), "Виробник не обраний", Toast.LENGTH_SHORT).show();
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
                                                Toast.makeText(view.getContext(), "Ціна не обрана", Toast.LENGTH_SHORT).show();
                                                return;
                                            }

                                            string += spinner.getSelectedItem().toString();
                                            fragmentSendDataListener.onSendData(string);
                                        }
                                    }
        );
        buttonOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getActivity(), OpenActivity.class));
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SaveLoad.clearFile(getActivity());
            }
        });
    }
}
