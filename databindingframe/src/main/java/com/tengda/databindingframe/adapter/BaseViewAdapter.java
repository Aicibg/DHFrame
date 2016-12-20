/*
 * Copyright (C) 2016 MarkZhai (http://zhaiyifan.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tengda.databindingframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tengda.databindingframe.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Data Binding RecyclerView Adapter.
 *
 * @author markzhai on 16/8/25
 */
public abstract class  BaseViewAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {
    protected final LayoutInflater mLayoutInflater;

    protected List<T> mCollection;
    protected Presenter mPresenter;
    protected Decorator mDecorator;

    public interface Presenter {

    }

    public interface Decorator {
        void decorator(BindingViewHolder holder, int position, int viewType);
    }

    public BaseViewAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        Object item = mCollection.get(position);
        holder.getBinding().setVariable(BR.item, item);
        holder.getBinding().setVariable(BR.presenter, getPresenter());
        holder.getBinding().executePendingBindings();
        if (mDecorator != null) {
            mDecorator.decorator(holder, position, getItemViewType(position));
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return mCollection.size();
    }

    public void clear() {
        mCollection.clear();
        notifyDataSetChanged();
    }

    /**
     * 刷新数据，初始化数据
     *
     * @param list
     */
    public void setDatas(List<T> list) {
        if (this.mCollection != null) {
            if (null != list) {
                List<T> temp = new ArrayList<>();
                temp.addAll(list);
                this.mCollection.clear();
                this.mCollection.addAll(temp);
            } else {
                this.mCollection.clear();
            }
        } else {
            this.mCollection = list;
        }
        notifyDataSetChanged();
    }

    /**
     * 删除一条数据
     * 会自动定向刷新
     *
     * @param i
     */
    public void remove(int i) {
        if (null != mCollection && mCollection.size() > i && i > -1) {
            mCollection.remove(i);
            notifyItemRemoved(i);
        }
    }

    /**
     * 添加一条数据 至队尾
     * 会自动定向刷新
     *
     * @param data
     */
    public void add(T data) {
        if (data != null && mCollection != null) {
            mCollection.add(data);
            notifyItemInserted(mCollection.size());
        }
    }

    /**
     * 在指定位置添加一条数据
     * 会自动定向刷新
     * <p>
     * 如果指定位置越界，则添加在队尾
     *
     * @param position
     * @param data
     */
    public void add(int position, T data) {
        if (data != null && mCollection != null) {
            if (mCollection.size() > position && position > -1) {
                mCollection.add(position, data);
                notifyItemInserted(position);
            } else {
                add(data);
            }
        }
    }


    /**
     * 加载更多数据
     *
     * @param list
     */
    public void addDatas(List<T> list) {
        if (null != list) {
            List<T> temp = new ArrayList<>();
            temp.addAll(list);
            if (this.mCollection != null) {
                this.mCollection.addAll(temp);
            } else {
                this.mCollection = temp;
            }
            notifyDataSetChanged();
        }

    }

    public List<T> getData() {
        return mCollection;
    }

    public void setDecorator(Decorator decorator) {
        mDecorator = decorator;
    }

    public void setPresenter(Presenter presenter) {
        mPresenter = presenter;
    }

    protected Presenter getPresenter() {
        return mPresenter;
    }
}
