package com.tengda.databindingframe.widgets.base;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tengda.databindingframe.adapter.BindingViewHolder;
import com.tengda.databindingframe.adapter.SingleTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者：Nipuream
 * 时间: 2016-08-05 14:59
 * 邮箱：571829491@qq.com
 */
public interface LoaderStateInterface {


    /**
     * 上拉加载更多
     */
    public static final int IDLE = 0x21;

    /**
     * 释放加载更多
     */
    public static final int RELEASE_LOAD_MORE = 0x22;

    /**
     * 正在加载更多
     */
    public static final int LOADING_MORE = 0x23;


    /**
     * 到底了
     */
    public static final int NO_MORE = 0x24;


    public void setState(int state);

    public int getState();


}
