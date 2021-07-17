package com.example.guesstheday;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.icu.text.UFormat;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.text.format.DateFormat;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;


public class Second_Screen extends AppCompatActivity {

    private static final String TAG = "Second_Screen";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_page);
        Log.d(TAG, "OnCreate: Started");

        Intent intent = getIntent();

        String score = intent.getStringExtra("Score");
        TextView title = (TextView) findViewById(R.id.textView);

        TextView sc_no = (TextView) findViewById(R.id.textView2);

        Button done = (Button) findViewById(R.id.done);

        sc_no.setText(score);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
