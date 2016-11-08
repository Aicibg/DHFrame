package com.dhao.dhframe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dhao.framelibrary.base.BaseAppCompatActivity;
import com.umeng.analytics.MobclickAgent;

public class MainActivity extends BaseAppCompatActivity {
    private Button btStart, btActivity;
    private FirstFragment firstFragment;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        btStart = (Button) findViewById(R.id.button);
        btActivity = (Button) findViewById(R.id.bt_start_activity);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstFragment.start(new BackFragment());
                showSnack("启动Fragment", btStart, Color.parseColor("#239120"), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("哈哈");
                    }
                });
            }
        });

        btActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyGo(SecondActivity.class);
                showToast("启动Activity");
            }
        });
        firstFragment = new FirstFragment();
        loadRootFragment(R.id.fragment_content, firstFragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
    //    MobclickAgent.onPageStart("MainActivity"); //统计页面(仅有Activity的应用中SDK自动调用，不需要单独写。"SplashScreen"为页面名称，可自定义)
        MobclickAgent.onResume(this);          //统计时长
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   MobclickAgent.onPageEnd("MainActivity"); // （仅有Activity的应用中SDK自动调用，不需要单独写）保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息。"SplashScreen"为页面名称，可自定义
        MobclickAgent.onPause(this);
    }
}
