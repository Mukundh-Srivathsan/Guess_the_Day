package com.example.guesstheday;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int score=0;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: Started");
        normal();
    }

    void normal()
    {
        Random random = new Random();

        TextView ques = (TextView) findViewById(R.id.Question);
        Button firstButton = (Button) findViewById(R.id.button1);
        Button secondButton = (Button) findViewById(R.id.button2);
        Button thirdButton = (Button) findViewById(R.id.button3);
        Button fourthButton = (Button) findViewById(R.id.button4);

        LocalDate date = getLocalDate();
        String day = date.getDayOfWeek().toString();
        ques.setText(date.toString());

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        boolean check[] = new boolean[7];

        check[search(daysOfWeek, day)] = true;

        int btno = random.ints(1, 5).findFirst().getAsInt();

        if (btno == 1) {
            firstButton.setText(day);

            int index = crctIndex(check);
            check[index] = true;
            secondButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            thirdButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            fourthButton.setText(daysOfWeek[index]);
        }
        else if (btno == 2) {
            secondButton.setText(day);

            int index = crctIndex(check);
            check[index] = true;
            firstButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            thirdButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            fourthButton.setText(daysOfWeek[index]);
        }
        else if (btno == 3) {
            thirdButton.setText(day);

            int index = crctIndex(check);
            check[index] = true;
            firstButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            secondButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            fourthButton.setText(daysOfWeek[index]);
        }
        else {
            fourthButton.setText(day);

            int index = crctIndex(check);
            check[index] = true;
            firstButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            secondButton.setText(daysOfWeek[index]);

            index = crctIndex(check);
            check[index] = true;
            thirdButton.setText(daysOfWeek[index]);
        }
        MainActivity main = new MainActivity();

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day.equalsIgnoreCase(firstButton.getText().toString()))
                {
                    score++;
                    normal();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Second_Screen.class);
                    intent.putExtra("Score", ""+score);
                    startActivity(intent);
                    System.exit(0);
                }
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day.equalsIgnoreCase(secondButton.getText().toString()))
                {
                    score++;
                    normal();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Second_Screen.class);
                    intent.putExtra("Score", ""+score);
                    startActivity(intent);
                    System.exit(0);
                }
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day.equalsIgnoreCase(thirdButton.getText().toString()))
                {
                    score++;
                    normal();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Second_Screen.class);
                    intent.putExtra("Score", ""+score);
                    startActivity(intent);
                    System.exit(0);
                }
            }
        });

        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day.equalsIgnoreCase(fourthButton.getText().toString()))
                {
                    score++;
                    normal();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Second_Screen.class);
                    intent.putExtra("Score", ""+score);
                    startActivity(intent);
                    System.exit(0);
                }
            }
        });
    }


    int search(String[] days, String day) {
        for (int i = 0; i < 7; i++)
        {
            if (days[i].equalsIgnoreCase(day)) return i;
        }
        return -1;
    }

    int crctIndex(boolean[] check)
    {
        Random random = new Random();
        int index = random.ints(0, 7).findFirst().getAsInt();
        if (check[index] != true) return index;

        return crctIndex(check);
    }
    LocalDate getLocalDate() {

        Random random = new Random();
        int day = 0;
        int year = random.ints(0, 3000).findFirst().getAsInt();
        if(year%4==0 && year%100==0 && year%400==0)
            day = random.ints(0, 366).findFirst().getAsInt();
        else
            day = random.ints(0, 365).findFirst().getAsInt();

        return LocalDate.ofYearDay(year, day);
    }

}