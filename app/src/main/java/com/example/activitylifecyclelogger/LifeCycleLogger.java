package com.example.activitylifecyclelogger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/*
 * LifeCycleLogger class extends the Activity class and overrides
 * the 6 Activity callback methods: onCreate(), onStart(), onResume()
 * onStop(), onRestart() and onDestroy(). Purpose of this class is to
 * create an INFO log whenever a callback method has been called by the system.
 */
public class LifeCycleLogger extends Activity {

    private String mLogTag = "ACTIVITY LIFE CYCLE";

    /*
     * onCreate() method is called when the system creates the activity.
     * Basic application startup logic that should only happen once for the entire
     * life of the activity must be performed in this callback method.
     * Takes up savedInstanceState as parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // All hook methods must always call its super class method.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(mLogTag, "onCreate() method is called. " +
                "Activity is being created.");
        if(savedInstanceState == null)
            Log.i(mLogTag, "No Saved Instance of this Activity");
        else
            Log.i(mLogTag, "Saved Instance present.");
    }

    /*
     * System invokes onStart() callback when the activity enters the 'Started' state.
     * onStart() makes the activity visible to the user, as the app prepares for
     * the activity to enter the foreground and become interactive.
     * Once this callback finishes, the activity enters the 'Resumed' state, and
     * the system enters the onResume() method.
     */
    @Override
    protected void onStart() {
        // All Activity callback methods must always call its super class method.
        super.onStart();
        Log.i(mLogTag, "onStart() method is called. " +
                "Activity is being started.");
    }

    /*
     * When the activity goes to the 'Resumed' state, it comes to the foreground,
     * and then the system invokes the onResume() callback method.
     * This is the state where the app interacts with the user.
     * The app stays in this state until something happens to take away the
     * focus from the app, such as:
     *      - receiving a phone call
     *      - user's navigating to another activity
     *      - or the device screen's turning off
     */
    @Override
    protected void onResume() {
        // All Activity callback methods must always call its super class method.
        super.onResume();
        Log.i(mLogTag, "onResume() method is called." +
                "Activity is currently in focus.");
    }

    /*
     * The system calls onPause() as the first indication that the user is
     * leaving the activity. It indicates that the activity is no longer in the
     * foreground. Use this method to pause or adjust operations that shouldn't
     * continue while the Activity is in the 'Paused' state, and that you expect
     * to resume shortly.
     */
    @Override
    protected void onPause() {
        // All Activity callback methods must always call its super class method.
        super.onPause();
        Log.i(mLogTag, "onPause() method is called." +
                "Activity will lose focus.");
    }

    /*
     * onStop() callback method is called when the activity is no longer visible
     * to the user. This means that the activity has entered the 'Stopped' state.
     * In this method, the app should release or adjust resources that aren't
     * needed while the app is not visible to the user.
     */
    @Override
    protected void onStop() {
        // All Activity callback methods must always call its super class method.
        super.onStop();
        Log.i(mLogTag, "onStop() method is called." +
                "Activity is no longer visible.");
        // Release resources here that aren't needed.
    }

    /*
     * onRestart() is called after onStop() when the current activity is being
     * re-displayed to the user. This call will be followed by onStart(), then
     * onResume().
     */
    @Override
    protected void onRestart() {
        // All Activity callback methods must always call its super class method.
        super.onRestart();
        Log.i(mLogTag, "" + "onRestart() method is called." +
                "User navigates to the Activity.");
    }

    /*
     * onDestroy() is called before the activity is destroyed. This method should
     * release all resources that have not yet been release by earlier callback
     * methods such as onStop().
     */
    @Override
    protected void onDestroy() {
        // All Activity callback methods must always call its super class method.
        super.onDestroy();
        Log.i(mLogTag, "onDestroy() method is called." +
                "Activity is about to be destroyed.");
        // All resources that haven't been release yet must be released here.
    }
}
