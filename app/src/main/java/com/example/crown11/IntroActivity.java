package com.example.crown11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {
    java.util.Timer Timer;
    private String logtag= MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
            Timer = new Timer();
            Timer.schedule(new TimerTask() {
                               @Override
                               public void run() {
                                   Log.d(logtag,"sent to main activity after 3000ms");
                                   Intent intent = (new Intent(IntroActivity.this, MainActivity.class));
                                   startActivity(intent);
                                   overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                   finish();
                               }
                           },
                    3000);
        }
    }

