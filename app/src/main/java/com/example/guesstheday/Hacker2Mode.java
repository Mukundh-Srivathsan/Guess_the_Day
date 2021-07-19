package com.example.guesstheday;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Random;

public class Hacker2Mode extends AppCompatActivity {

    private static final String TAG = "Hacker2Mode";

    int score;
    long time;
    boolean isOrientation;
    String day;

    TextView ques;
    TextView timer;
    Button firstButton;
    Button secondButton;
    Button thirdButton;
    Button fourthButton;
    Vibrator vibrate;
    ConstraintLayout Layout;
    CountDownTimer countDownTimer;
    CountDownTimer progressTimer;
    ProgressBar circle;

    Handler mHandler = new Handler();


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("option1", (String) firstButton.getText());
        outState.putString("option2", (String) secondButton.getText());
        outState.putString("option3", (String) thirdButton.getText());
        outState.putString("option4", (String) fourthButton.getText());
        outState.putString("question", (String) ques.getText());
        outState.putLong("time", time);
        outState.putInt("score", score);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        firstButton.setText(savedInstanceState.getString("option1"));
        secondButton.setText(savedInstanceState.getString("option2"));
        thirdButton.setText(savedInstanceState.getString("option3"));
        fourthButton.setText(savedInstanceState.getString("option4"));
        ques.setText(savedInstanceState.getString("question"));

        score = savedInstanceState.getInt("score");
        isOrientation = false;

        time = savedInstanceState.getLong("time");
        stopTimer();
        stopCircleTimer();
        startTimer();
        startCircleTimer();

        super.onRestoreInstanceState(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacker2_mode);
        Log.d(TAG, "OnCreate : HackerMode2");

        ques = (TextView) findViewById(R.id.question);

        timer = (TextView) findViewById(R.id.timer);
        firstButton = (Button) findViewById(R.id.h2button1);
        secondButton = (Button) findViewById(R.id.h2button2);
        thirdButton = (Button) findViewById(R.id.h2button3);
        fourthButton = (Button) findViewById(R.id.h2button4);

        circle = (ProgressBar) findViewById(R.id.progress_bar);

        Layout = findViewById(R.id.cL);

        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        score=0;

        isOrientation=true;

        time = 60000;
        startTimer();
        startCircleTimer();

        start();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    void start() {
        Random random = new Random();

        LocalDate date = getLocalDate();

        if (isOrientation)
            day = date.getDayOfWeek().toString();
        else
            isOrientation = true;
        ques.setText(date.toString());


        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        boolean[] check = new boolean[7];

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
        } else if (btno == 2) {
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
        } else if (btno == 3) {
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
        } else {
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


        mHandler.postDelayed(normalbg, 100);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate.vibrate(1000);

                if (day.equalsIgnoreCase(firstButton.getText().toString())) {
                    Layout.setBackgroundColor(Color.GREEN);

                    mHandler.postDelayed(crct, 100);

                } else {

                    Layout.setBackgroundColor(Color.RED);
                    time -= 2000;

                    stopTimer();
                    stopCircleTimer();
                    startTimer();
                    startCircleTimer();
                    mHandler.postDelayed(wrong, 100);
                }
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate.vibrate(1000);

                if (day.equalsIgnoreCase(secondButton.getText().toString())) {
                    Layout.setBackgroundColor(Color.GREEN);

                    mHandler.postDelayed(crct, 100);

                } else {

                    Layout.setBackgroundColor(Color.RED);
                    time -= 2000;
                    stopTimer();
                    stopCircleTimer();
                    startTimer();
                    startCircleTimer();
                    mHandler.postDelayed(wrong, 100);
                }
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate.vibrate(1000);

                if (day.equalsIgnoreCase(thirdButton.getText().toString())) {
                    Layout.setBackgroundColor(Color.GREEN);

                    mHandler.postDelayed(crct, 100);

                } else {

                    Layout.setBackgroundColor(Color.RED);
                    time -= 2000;

                    stopTimer();
                    stopCircleTimer();
                    startTimer();
                    startCircleTimer();
                    mHandler.postDelayed(wrong, 100);
                }
            }
        });

        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate.vibrate(1000);

                if (day.equalsIgnoreCase(fourthButton.getText().toString())) {
                    Layout.setBackgroundColor(Color.GREEN);

                    mHandler.postDelayed(crct, 100);

                } else {

                    Layout.setBackgroundColor(Color.RED);
                    time -= 2000;

                    stopTimer();
                    stopCircleTimer();
                    startTimer();
                    startCircleTimer();
                    mHandler.postDelayed(wrong, 100);
                }
            }
        });
    }


    int search(String[] days, String day) {
        for (int i = 0; i < 7; i++) {
            if (days[i].equalsIgnoreCase(day)) return i;
        }
        return -1;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    int crctIndex(boolean[] check) {
        Random random = new Random();
        int index = random.ints(0, 7).findFirst().getAsInt();
        if (check[index] != true) return index;

        return crctIndex(check);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    LocalDate getLocalDate() {

        Random random = new Random();
        int day = 0;
        int year = random.ints(0, 3000).findFirst().getAsInt();
        if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
            day = random.ints(0, 366).findFirst().getAsInt();
        else
            day = random.ints(0, 365).findFirst().getAsInt();


        LocalDate localDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            localDate = LocalDate.ofYearDay(year, day);
        }
        return localDate;
    }

    private Runnable crct = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void run() {
            score += 2;
            start();
        }
    };

    private Runnable wrong = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void run() {
            score--;
            mHandler.postDelayed(normalbg, 100);
        }
    };

    private Runnable normalbg = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void run() {
            Layout.setBackgroundColor(Color.BLACK);
        }
    };

    void startTimer() {
        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished;
                int seconds = (int) time / 1000;
                timer.setText("" + seconds);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Hacker2Mode.this, HackerScore.class);
                intent.putExtra("Score", "" + score);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                startActivity(intent);

                System.exit(0);
            }
        }.start();
    }

    void stopTimer() {
        countDownTimer.cancel();
    }

    void startCircleTimer() {
        progressTimer = new CountDownTimer(time, 100) {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTick(long millisUntilFinished) {
                circle.setMax(60);

                circle.setProgress((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    void stopCircleTimer(){
        circle.setProgress(0);
        progressTimer.cancel();
    }



}