package com.dhao.framelibrary.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by DongHao on 2016/11/8.
 * Description:
 */

public abstract class MultiTypeAdapter <T,VH extends BaseViewHolder> extends RecyclerView.Adapter<VH>{
    private final Object mLock = new Object();
    private Context mContext;
    private List<T> mDatas;
    protected ArrayMap<Integer,Integer> mItemTypeToLayoutMap=new ArrayMap<>();
    private int removeIndex = -1;
    private boolean removeSuccess;
    private int viewTypeSize=1;

    public MultiTypeAdapter() {
        mDatas = new ArrayList<>();
    }

    public Context getContext() {
        return mContext;
    }

    protected View getView(@LayoutRes int layoutId, ViewGroup parent) {
        if (null == mContext) {
            mContext = parent.getContext();
        }
        return LayoutInflater.from(mContext).inflate(layoutId, parent, false);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        bindView(holder,position);
    }

    protected abstract void bindView(VH holder, int position);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return (VH) new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(viewType),parent,false));
    }

    protected  int getLayoutRes(int viewType){
        return mItemTypeToLayoutMap.get(viewType);
    }

    public void addViewTypeMap(Map<Integer,Integer> typeMap){
        mItemTypeToLayoutMap.putAll(typeMap);
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 1;
        }
        return 2;
    }

    @Override
    public int getItemCount() {
        if (mDatas != null && mDatas.size() != 0) {
            return mDatas.size();
        } else {
            return 0;
        }
    }


    public void add(T object) {
        synchronized (mLock) {
            if (null != mDatas) {
                mDatas.add(object);
            }
        }
        notifyItemInserted(getItemCount() - 1);
    }

    public void addAll(Collection<? extends T> collection) {
        synchronized (mLock) {
            if (null != mDatas) {
                mDatas.addAll(collection);
            }
        }
        notifyItemRangeInserted(getItemCount() - collection.size(), getItemCount() - 1);
    }

    @SafeVarargs
    public final void addAll(T... items) {
        synchronized (mLock) {
            if (null != mDatas) {
                Collections.addAll(mDatas, items);
            }
        }
        notifyItemRangeInserted(getItemCount() - items.length, getItemCount() - 1);
    }

    public void insert(T object, int index) {
        synchronized (mLock) {
            if (null != mDatas) {
                mDatas.add(index, object);
            }
        }
        notifyItemInserted(index);
    }

    public void remove(int index) {
        if (index > 0 && index < getItemCount()) {
            synchronized (mLock) {
                mDatas.remove(index);
            }
            notifyItemRemoved(index);
        } else {
            throw new IllegalArgumentException("index less than zero or index more than list's size");
        }
    }


    public void remove(T object) {
        removeIndex = -1;
        removeSuccess = false;
        synchronized (mLock) {
            for (int index = 0; index < getItemCount(); index++) {
                if (object.equals(getItem(index))) {
                    removeIndex = index;
                }
            }
            if (mDatas != null) {
                removeSuccess = mDatas.remove(object);
            }
        }
        if (removeSuccess) {
            notifyItemRemoved(removeIndex);
        }
    }

    public void clear() {
        synchronized (mLock) {
            if (mDatas != null) {
                mDatas.clear();
            }
        }
        notifyDataSetChanged();
    }

    public void sort(Comparator<? super T> comparator) {
        synchronized (mLock) {
            if (mDatas != null) {
                Collections.sort(mDatas, comparator);
            }
        }
        notifyDataSetChanged();
    }

    public void update(List<T> mDatas) {
        synchronized (mLock) {
            this.mDatas = mDatas;
        }
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    public int getPosition(T item) {
        return mDatas.indexOf(item);
    }

    public List<T> getData() {
        if (null != mDatas) {
            return mDatas;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
