package com.dhao.dhframe;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by DongHao on 2016/11/7
 * Description:
 */

public class MyApplication extends Application{

    private String YOUR_TAG="MyTest";

    @Override
    public void onCreate() {
        super.onCreate();

        CrashReport.initCrashReport(getApplicationContext(), "e148aa2f3e", true);

        Logger.init(YOUR_TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(1)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(2);                // default 0

        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.openActivityDurationTrack(false);
        /** 设置是否对日志信息进行加密, 默认false(不加密). */
        MobclickAgent.enableEncrypt(true);
        //打开调试模式后，您可以在logcat中查看您的数据是否成功发送到友盟服务器，以及集成过程中的出错原因等，友盟相关log的tag是MobclickAgent。
        MobclickAgent.setDebugMode( true );
    }
}
