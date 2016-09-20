package com.dhao.dhframe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.dhao.framelibrary.base.BaseAppCompatActivity;

public class MainActivity extends BaseAppCompatActivity {
    private Button btStart,btActivity;
    private FirstFragment firstFragment;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        btStart= (Button) findViewById(R.id.button);
        btActivity= (Button) findViewById(R.id.bt_start_activity);

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
        firstFragment=new FirstFragment();
        loadRootFragment(R.id.fragment_content,firstFragment);
    }
}
