package com.jacky.android9.hidden;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

public class InstrumentWrapper extends Instrumentation {
    private final Instrumentation base;

    public InstrumentWrapper(Instrumentation base) {
        this.base = base;
    }

    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return base.newActivity(cl, className, intent);
    }
}
