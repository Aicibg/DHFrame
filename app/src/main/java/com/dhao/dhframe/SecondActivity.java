package com.dhao.dhframe;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dhao.framelibrary.base.BaseAppCompatActivity;
import com.dhao.framelibrary.base.BaseSwipeBackCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SecondActivity extends BaseSwipeBackCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter;
    String[] str=new String[]{"aaa","bbb","ccc"};
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_second;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter=new MyAdapter();
//        ArrayMap<Integer,Integer> map=new ArrayMap<>();
//        map.put(1,R.layout.item_view1);
//        map.put(2,R.layout.item_view);
//        mMyAdapter.addViewTypeMap(map);
        try {
            OutputStream out=openFileOutput("abc",MODE_PRIVATE);
            OutputStreamWriter writer=new OutputStreamWriter(out);
                writer.write("121312");
            } catch (IOException e) {
                e.printStackTrace();
            }
        mMyAdapter.addAll(Arrays.asList(str));
        mRecyclerView.setAdapter(mMyAdapter);
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
