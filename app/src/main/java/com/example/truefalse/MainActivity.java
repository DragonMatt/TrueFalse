package com.example.truefalse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private Button buttonTrue;
    private Button buttonFalse;
    public InputStream XmlFileInputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XmlFileInputStream = getResources().openRawResource(R.raw.questions); // getting XML
        String json = readTextFile(XmlFileInputStream);

        wireWidgets();
        setListeners();
    }

    private void wireWidgets() {
        textViewQuestion = findViewById(R.id.textView_main_question);
        textViewScore = findViewById(R.id.textView_main_score);
        buttonTrue = findViewById(R.id.button_main_true);
        buttonFalse = findViewById(R.id.button_main_false);
    }

    private void setListeners() {
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
