package com.example.crown11.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.crown11.R;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {
    private static final String ACTIVATED = null;
    protected static Boolean LooedIn = false;
    private java.util.Timer Timer;
    private String logtag = MainActivity.class.getSimpleName();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if (i == 0) {
            Timer = new Timer();
            Timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Log.d(logtag, "sent to main activity after 3000ms");
                    Intent intent = (new Intent(IntroActivity.this, MainActivity.class));
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            }, 3000);
            i++;

        } else {
            Intent intent = new Intent(IntroActivity.this, ProfileScreen.class);
            startActivity(intent);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt(ACTIVATED, i);


        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}

