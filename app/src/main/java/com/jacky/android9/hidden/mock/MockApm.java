package com.jacky.android9.hidden.mock;

import android.app.Instrumentation;

import com.jacky.android9.hidden.InstrumentWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MockApm {

    // works in android 9.0;
    public static boolean mock360ApmInstrumentationHook() {
        Method currentActivityThread;
        try {
            Class<?> c = Class.forName("android.app.ActivityThread");
            currentActivityThread = c.getDeclaredMethod("currentActivityThread");
            boolean acc = currentActivityThread.isAccessible();
            if (!acc) {
                currentActivityThread.setAccessible(true);
            }
            Object o = currentActivityThread.invoke(null);
            if (!acc) {
                currentActivityThread.setAccessible(acc);
            }
            Field f = c.getDeclaredField("mInstrumentation");
            acc = f.isAccessible();
            if (!acc) {
                f.setAccessible(true);
            }
            Instrumentation currentInstrumentation = (Instrumentation) f.get(o);
            Instrumentation ins = new InstrumentWrapper(currentInstrumentation);
            f.set(o, ins);
            if (!acc) {
                f.setAccessible(acc);
            }
            return true;
        } catch (NoSuchMethodException
            | IllegalAccessException
            | NoSuchFieldException
            | InvocationTargetException
            | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
