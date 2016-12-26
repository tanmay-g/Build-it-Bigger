package com.udacity.gradle.jokedisplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String jokeKey = "jokeKey";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jokedisplay);


        TextView jokeView = (TextView) findViewById(R.id.jokeTextView);
        String joke = getIntent().getStringExtra(jokeKey);
        Log.i(LOG_TAG, "onCreateView: " + joke);
        jokeView.setText(joke);
    }
}
