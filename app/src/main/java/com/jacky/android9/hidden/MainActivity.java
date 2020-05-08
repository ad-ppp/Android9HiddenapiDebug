package com.jacky.android9.hidden;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.jacky.android9.hidden.util.ReflectUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reflectHideFieldTest();
        reflectInstrumentation();
    }

    private void reflectInstrumentation() {
        final Instrumentation mInstrumentation;
        try {
            mInstrumentation = ReflectUtils
                .get(Activity.class, "mInstrumentation", this);

            if (mInstrumentation != null) {
                mInstrumentation.callActivityOnCreate(this, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * access 非sdk field in android9.0
     */
    private void reflectHideFieldTest() {
        final Application application = getApplication();
        final Object mLoadApk;
        try {
            mLoadApk = ReflectUtils.get(Application.class, "mLoadApk", application);
            if (mLoadApk != null) {
                final File file = ReflectUtils.get(mLoadApk.getClass(), "mDataDirFile", mLoadApk);
                if (file != null) {
                    Log.d(tag, "LoadApk,mDataDirFile:" + file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
