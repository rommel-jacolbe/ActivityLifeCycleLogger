package com.example.activitylifecyclelogger;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends LifeCycleLogger {

    private String mLogTag = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // All hook methods must always call its super class method.
        super.onCreate(savedInstanceState);
        // Set activity_main.xml as the layout to be used for MainActivity
        setContentView(R.layout.activity_main);
        Log.i(mLogTag,
                "onCreate() method called. MainActivity is being created");
    }

    // This method is called when user selects 'Yes' button in the MainActivity.
    // This method creates an intent via a static method from ResultActivity class
    // and calls startActivity() to start ResultActivity with the newly created
    // Intent as a parameter.
    public void ShowResultYes(View view) {
        startActivity(ResultActivity.makeIntent(
                this, ResultActivity.SHOW_HI));
        Log.i(mLogTag, "Show Result for 'Yes");
    }

    // This method is called when user selects 'No' button in the MainActivity.
    // This method creates an intent via a static method from ResultActivity class
    // and calls startActivity() to start ResultActivity with the newly created
    // Intent as a parameter.
    public void ShowResultNo(View view) {
        startActivity(ResultActivity.makeIntent(
                this, ResultActivity.SHOW_HELLO));
        Log.i(mLogTag, "Show Result for 'No");
    }
}