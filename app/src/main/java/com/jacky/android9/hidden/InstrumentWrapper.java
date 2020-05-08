package com.jacky.android9.hidden;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InstrumentWrapper extends Instrumentation {
    private static final String tag = "InstrumentWrapper";
    private final Instrumentation base;

    public InstrumentWrapper(Instrumentation base) {
        this.base = base;
    }

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        Log.d(tag, "callActivityOnCreate:" + activity.getClass().getSimpleName());
        base.callActivityOnCreate(activity, icicle);
    }

    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return base.newActivity(cl, className, intent);
    }
}
