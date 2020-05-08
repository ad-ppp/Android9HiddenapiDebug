## MOCK 360-APM 
具体查看： MockApm.java文件
- 模拟 360APM hook，currentActivityThread 的 mInstrumentation。包装此对象，并设置新的Instrumentation对象到currentActivityThread中。


## Hidden api访问测试
- [Android 9.0 非sdk接口限制。](https://developer.android.com/distribute/best-practices/develop/restrictions-non-sdk-interfaces)
- [Android 11.0 非sdk接口限制也要来啦](https://developer.android.com/preview/non-sdk-11)

---

Logs
```
2020-05-07 13:38:32.452 22883-22883/? I/android9.hidde: Not late-enabling -Xcheck:jni (already on)
2020-05-07 13:38:32.470 22883-22883/? W/android9.hidde: Unexpected CPU variant for X86 using defaults: x86
2020-05-07 13:38:32.749 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden method Landroid/graphics/drawable/Drawable;->getOpticalInsets()Landroid/graphics/Insets; (light greylist, linking)
2020-05-07 13:38:32.750 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden field Landroid/graphics/Insets;->left:I (light greylist, linking)
2020-05-07 13:38:32.750 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden field Landroid/graphics/Insets;->right:I (light greylist, linking)
2020-05-07 13:38:32.750 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden field Landroid/graphics/Insets;->top:I (light greylist, linking)
2020-05-07 13:38:32.750 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden field Landroid/graphics/Insets;->bottom:I (light greylist, linking)
2020-05-07 13:38:32.844 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (light greylist, reflection)
2020-05-07 13:38:32.845 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden method Landroid/view/ViewGroup;->makeOptionalFitsSystemWindows()V (light greylist, reflection)
2020-05-07 13:38:32.854 22883-22883/com.jacky.android9.hidden W/android9.hidde: Accessing hidden method Landroid/widget/TextView;->getTextDirectionHeuristic()Landroid/text/TextDirectionHeuristic; (light greylist, linking)
2020-05-07 13:38:32.896 22883-22883/com.jacky.android9.hidden W/System.err: java.lang.NoSuchFieldException: No field mLoadApk in class Landroid/app/Application; (declaration of 'android.app.Application' appears in /system/framework/framework.jar)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at java.lang.Class.getDeclaredField(Native Method)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at com.jacky.android9.hidden.MainActivity.reflectObject(MainActivity.java:40)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at com.jacky.android9.hidden.MainActivity.reflectHideFieldTest(MainActivity.java:28)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at com.jacky.android9.hidden.MainActivity.onCreate(MainActivity.java:20)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.Activity.performCreate(Activity.java:7136)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.Activity.performCreate(Activity.java:7127)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2893)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3048)
2020-05-07 13:38:32.897 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1808)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at android.os.Handler.dispatchMessage(Handler.java:106)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at android.os.Looper.loop(Looper.java:193)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:6669)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
2020-05-07 13:38:32.898 22883-22883/com.jacky.android9.hidden W/System.err:     at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
2020-05-07 13:38:32.899 22883-22883/com.jacky.android9.hidden W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858)
2020-05-07 13:38:32.915 22883-22883/com.jacky.android9.hidden D/OpenGLRenderer: Skia GL Pipeline
2020-05-07 13:38:32.950 22883-22911/com.jacky.android9.hidden I/ConfigStore: android::hardware::configstore::V1_0::ISurfaceFlingerConfigs::hasWideColorDisplay retrieved: 0
2020-05-07 13:38:32.951 22883-22911/com.jacky.android9.hidden I/ConfigStore: android::hardware::configstore::V1_0::ISurfaceFlingerConfigs::hasHDRDisplay retrieved: 0
2020-05-07 13:38:32.951 22883-22911/com.jacky.android9.hidden I/OpenGLRenderer: Initialized EGL, version 1.4
2020-05-07 13:38:32.951 22883-22911/com.jacky.android9.hidden D/OpenGLRenderer: Swap behavior 1
2020-05-07 13:38:32.951 22883-22911/com.jacky.android9.hidden W/OpenGLRenderer: Failed to choose config with EGL_SWAP_BEHAVIOR_PRESERVED, retrying without...
2020-05-07 13:38:32.951 22883-22911/com.jacky.android9.hidden D/OpenGLRenderer: Swap behavior 0
2020-05-07 13:38:32.960 22883-22911/com.jacky.android9.hidden D/EGL_emulation: eglCreateContext: 0xec6db1e0: maj 3 min 0 rcv 3
2020-05-07 13:38:32.967 22883-22911/com.jacky.android9.hidden D/EGL_emulation: eglMakeCurrent: 0xec6db1e0: ver 3 0 (tinfo 0xf23525d0)
2020-05-07 13:38:33.052 22883-22911/com.jacky.android9.hidden D/EGL_emulation: eglMakeCurrent: 0xec6db1e0: ver 3 0 (tinfo 0xf23525d0)
```