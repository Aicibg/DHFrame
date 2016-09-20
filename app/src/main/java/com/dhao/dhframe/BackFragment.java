package com.dhao.dhframe;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dhao.framelibrary.base.BaseSwipeBackCompatFragment;

/**
 * Created by DongHao on 2016/9/20.
 * Description:
 */
public class BackFragment extends BaseSwipeBackCompatFragment{
    TextView textView;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_back;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
        textView= (TextView) view.findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
    }


}
