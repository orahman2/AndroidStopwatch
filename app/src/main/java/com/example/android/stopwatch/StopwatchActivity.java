package com.example.android.stopwatch;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends Activity {

    private boolean running;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }

    public void onStart(View view) {
        running = true;
    }

    public void onStop(View view) {
        running = false;
    }

    public void onReset(View view) {
        running = false;
        seconds = 0;
    }

    public void runTimer(){
        final TextView view = (TextView) findViewById(R.id.time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",hours, minutes, secs);
                view.setText(time);
                if(running)seconds++;
                handler.postDelayed(this,1000);
            }
        });
    }
}