package com.dhao.dhframe;

import android.os.Bundle;

import com.dhao.framelibrary.base.BaseAppCompatActivity;
import com.dhao.framelibrary.base.BaseSwipeBackCompatActivity;

public class SecondActivity extends BaseSwipeBackCompatActivity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_second;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }
}
