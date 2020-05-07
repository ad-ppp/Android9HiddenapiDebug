package com.jacky.android9.hidden;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reflectHideFieldTest();
    }

    /**
     * access 非sdk field in android9.0
     */
    private void reflectHideFieldTest() {
        final Application application = getApplication();
        final Object mLoadApk = reflectObject(application, "mLoadApk");
        if (mLoadApk != null) {
            final File file = reflectObject(mLoadApk, "mDataDirFile");
            if (file != null) {
                Log.d(tag, "LoadApk,mDataDirFile:" + file.getAbsolutePath());
            }
        }
    }


    private <T> T reflectObject(Object instance, String name) {
        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return (T) field.get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
