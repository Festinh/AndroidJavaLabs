package com.example.lab2android.utility;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoad {

    public final static String FILE_NAME = "content.txt";

    public static void saveData(View view, String text) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(view.getContext().getFilesDir() + FILE_NAME, true))) {
            bw.write(text);
            bw.newLine();
            Toast.makeText(view.getContext(), "Результат збережено" , Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public static String loadText(Activity activity){
        try (BufferedReader reader = new BufferedReader(new FileReader(activity.getFilesDir() + FILE_NAME))) {
            String line= reader.readLine();
            if(line==null){
                Toast.makeText(activity,"File is empty", Toast.LENGTH_SHORT).show();
                return "";
            }
            StringBuilder res = new StringBuilder();
            res.append(line);
            res.append("\n");
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            return res.toString();
//            TextView textView = context.getAcivity().findViewById(R.id.textView2);
//            textView.setText(res.toString());
        }
        catch (IOException e) {
//            e.printStackTrace();
            Toast.makeText(activity,"File is empty", Toast.LENGTH_SHORT).show();
            return "";
        }
    }
    public static void clearFile(Activity activity){
        File fdelete = new File(activity.getFilesDir() + FILE_NAME);
        fdelete.delete();
    }
}
