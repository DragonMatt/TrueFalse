package com.example.truefalse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

        // since this screen is just a splash screen and doesn't have any game logic in it
        // instead of loading the questions here and passing them all individually to the GameActivity,
        // just load it from the GameActivity
        // that way you don't have to do all those putExtras.
        // do all your logic in GameActivity

        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent targetIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(targetIntent);
                finish();
            }
        });
    }

    private void wireWidgets() {
        buttonStartGame = findViewById(R.id.button_main_start);
    }

    private void setListeners() {

    }
}
