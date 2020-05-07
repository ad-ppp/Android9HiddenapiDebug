package com.jacky.android9.hidden;

import android.app.Application;
import android.util.Log;

import com.jacky.android9.hidden.mock.MockApm;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final boolean hook = MockApm.mock360ApmInstrumentationHook();
        final String result = hook ? "success" : "fail";
        Log.d("MyApplication", "hook instrumentation " + result);
    }
}
