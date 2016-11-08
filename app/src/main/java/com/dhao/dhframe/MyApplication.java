package com.dhao.dhframe;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by DongHao on 2016/11/7
 * Description:
 */

public class MyApplication extends Application {

    private String YOUR_TAG="MyTest";

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "e148aa2f3e", true);

        Logger.init(YOUR_TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(1)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(2)                // default 0
                .logAdapter(new MyLogAdapter()); //default AndroidLogAdapter
    }
}
