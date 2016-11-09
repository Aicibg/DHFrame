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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends BaseSwipeBackCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter;
    String[] str = new String[]{"aaa", "bbb", "ccc"};
    String[] fist = new String[]{"A", "B", "C", "D", "E", "F", "G"};
    List<CityBean> mCityBeens;
    CityAdapter mCityAdapter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_second;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mMyAdapter=new MyAdapter();
//        ArrayMap<Integer,Integer> map=new ArrayMap<>();
//        map.put(1,R.layout.item_view1);
//        map.put(2,R.layout.item_view);
//        mMyAdapter.addViewTypeMap(map);

//        mMyAdapter.addAll(Arrays.asList(str));
//        mRecyclerView.setAdapter(mMyAdapter);
        mCityBeens = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            CityBean cityBean = new CityBean(fist[i].toString() + "item", fist[i].toString());
            CityBean cityBean1=new CityBean(fist[i].toString() + "item1", fist[i].toString());
            mCityBeens.add(cityBean);
            mCityBeens.add(cityBean1);
        }
        mCityAdapter=new CityAdapter();
        mCityAdapter.addAll(mCityBeens);
        mRecyclerView.addItemDecoration(new TitleDecoration(this,mCityBeens));
        mRecyclerView.setAdapter(mCityAdapter);
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
