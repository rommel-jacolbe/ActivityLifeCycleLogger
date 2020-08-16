package com.example.activitylifecyclelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends LifeCycleLogger {

    // Key name for the extra data to be added in the Intent
    public static final String INTENT_EXTRA_CHOICE = "Choice";
    public static final int SHOW_HELLO = 1;
    public static final int SHOW_HI = 2;

    private int mGreetingMessage = 0;
    private final String mLogTag = "RESULT ACTIVITY";

    /* Method to make an explicit intent to start ResultActivity
     * parameters:  context - context of the calling activity
     *              data - data to be put as an extra in the intent
     *                   - determines what message should ResultActivity display
     * return: Intent - the newly created Intent
     */
    public static Intent makeIntent(Context context, int data) {
         return new Intent(context, ResultActivity.class).putExtra(INTENT_EXTRA_CHOICE, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // All Activity callback methods must always call its super class method.
        super.onCreate(savedInstanceState);
        Log.i(mLogTag,
                "onCreate() method is called. Activity is being started");
        // Set the layout to be used for the activity: activity_result.xml
        setContentView(R.layout.activity_result);
        // Create an object reference to reference the back button widget
        Button backButton = (Button)findViewById(R.id.backButton);
        // Create an OnClickListener for the the backButton. View.OnClickListener is
        // an interface. Since this is an interface, it's onClick() method must be
        // implemented. When onClick() method is called, ResultActivity shall be
        // paused (and will eventually closed and be destroyed), and the
        // MainActivity will be resumed.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        // All Activity callback methods must always call its super class method.
        super.onStart();
        Log.i(mLogTag,
                "onStart() method is called.");
        // Create an object reference resultTextView to reference the textView widget
        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);
        // Call getIntent() to get the Intent that started this activty
        mGreetingMessage = getIntent().getIntExtra(INTENT_EXTRA_CHOICE, 0);
        // Check what message to display based on the value set in extra: INTENT_EXTRA_CHOICE
        if(mGreetingMessage == SHOW_HELLO)
            resultTextView.setText(R.string.res_hello_message);
        else if(mGreetingMessage == SHOW_HI)
            resultTextView.setText(R.string.res_hi_message);
        else
            resultTextView.setText(R.string.res_try_again);
    }
    @Override
    protected void onResume() {
        // All Activity callback methods must always call its super class method.
        super.onResume();
        Log.i(mLogTag, "onResume() method called.");
    }

    @Override
    protected void onPause() {
        // All Activity callback methods must always call its super class method.
        super.onPause();
        Log.i(mLogTag, "onPause() method called.");
    }

    @Override
    protected void onStop() {
        // All Activity callback methods must always call its super class method.
        super.onStop();
        Log.i(mLogTag, "onStop() method called.");
    }

    @Override
    protected void onDestroy() {
        // All Activity callback methods must always call its super class method.
        super.onDestroy();
        Log.i(mLogTag, "onDestroy() method called.");
    }
}
