package com.example.guesstheday;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: Started");

        Intent intent = getIntent();
        String score = intent.getStringExtra("Score");
        String name = intent.getStringExtra("Name");


        Button Nrbtn = (Button) findViewById(R.id.Normal);
        Button Hkr1btn = (Button) findViewById(R.id.Hacker1);
        Button Hkr2btn = (Button) findViewById(R.id.Hacker2);
        TextView hscore = (TextView) findViewById(R.id.highscore);

        hscore.setText("Name: " + name + "\nHighScore: " + score);

        Nrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalMode.class);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                startActivity(intent);
            }
        });

        Hkr1btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hacker1Mode.class);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                startActivity(intent);
            }
        }));

        Hkr2btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hacker2Mode.class);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                startActivity(intent);
            }
        }));
    }
}