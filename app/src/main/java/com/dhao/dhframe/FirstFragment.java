package com.dhao.dhframe;

import android.os.Bundle;
import android.view.View;

import com.dhao.framelibrary.base.BaseAppCompatFragment;

/**
 * Created by DongHao on 2016/9/20.
 * Description:
 */
public class FirstFragment extends BaseAppCompatFragment{

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {

    }


}
