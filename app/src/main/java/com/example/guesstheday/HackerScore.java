package com.example.guesstheday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class HackerScore extends AppCompatActivity {

    private static final String TAG = "HackerScore";

    TextView title;
    TextView sc_no;
    TextView nameTitle;
    EditText enterName;
    Button done;

    Intent intent = getIntent();
    final String score = intent.getStringExtra("Score");

    String name;
    String shareScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacker_score);
        Log.d(TAG, "onCreate : HackerScore");


        title = (TextView) findViewById(R.id.scoreTitle);
        sc_no = (TextView) findViewById(R.id.scoreView);
        nameTitle = (TextView) findViewById(R.id.nameTitle);
        enterName = (EditText) findViewById(R.id.enterName);
        done = (Button) findViewById(R.id.doneBtn);

        sc_no.setText(score);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterName.getText().toString().equals("")) {
                    Toast.makeText(HackerScore.this, "Enter valid name", Toast.LENGTH_SHORT).show();
                } else {
                    //saveData();
                    System.exit(0);
                }
            }
        });
    }

   /* public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("highscore", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", enterName.getText().toString());
        editor.putString("score", score);

        editor.apply();
    }*/

   /* public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("highscore", MODE_PRIVATE);

        name = sharedPreferences.getString("name", "");
        shareScore = sharedPreferences.getString("score", "");


    }*/
}