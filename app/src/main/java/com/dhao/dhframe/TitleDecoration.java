package com.dhao.dhframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dhao.framelibrary.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongHao on 2016/11/9.
 * Description:
 */

public class TitleDecoration extends RecyclerView.ItemDecoration {

    private List<CityBean> mData;
    private Paint mPaint;
    private Rect mBounds;
    private int mTitleHeight = 0;
    private Context mContext;

    public TitleDecoration(Context context, List<CityBean> data) {
        mContext = context;
        mData = data;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(DensityUtils.dp2px(context,22));
        mBounds = new Rect();
        mTitleHeight=DensityUtils.dp2px(mContext,30);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (position > -1) {
            if (position == 0) {
                outRect.set(0, mTitleHeight, 0, 0);
            } else {
                if (mData.get(position).getTag() != null & !mData.get(position).getTag().equals
                        (mData.get(position - 1).getTag())) {
                    outRect.set(0, mTitleHeight, 0, 0);
                } else {
                    outRect.set(0, 0, 0, 0);
                }
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int position = params.getViewLayoutPosition();
            if (position > -1) {
                if (position == 0) {
                    drawTitleArea(c, left, right, child, params, position);
                } else {
                    if (mData.get(position).getTag() != null & !mData.get(position - 1).getTag().
                            equals(mData.get(position).getTag())) {
                        drawTitleArea(c, left, right, child, params, position);
                    }
                }
            }

        }
    }

    private void drawTitleArea(Canvas c, int left, int right, View child,
                               RecyclerView.LayoutParams params, int position) {
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        c.drawRect(left,child.getTop()-params.topMargin-mTitleHeight,right,child.getTop()-params.topMargin,mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.getTextBounds(mData.get(position).getTag(),0,mData.get(position).getTag().length(),mBounds);
        c.drawText(mData.get(position).getTag(),child.getPaddingLeft(),child.getTop()-params.topMargin-
                (mTitleHeight/2-mBounds.height()/2),mPaint);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int position=((LinearLayoutManager)parent.getLayoutManager()).findFirstVisibleItemPosition();
        String tag=mData.get(position).getTag();
        View child=parent.findViewHolderForLayoutPosition(position).itemView;
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        c.drawRect(parent.getPaddingLeft(),parent.getPaddingTop(),parent.getRight()-parent.getPaddingRight(),
                parent.getPaddingTop()+mTitleHeight,mPaint);
        mPaint.getTextBounds(tag,0,tag.length(),mBounds);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        c.drawText(tag,child.getPaddingLeft(),parent.getPaddingTop()+
                mTitleHeight-(mTitleHeight/2-mBounds.height()/2),mPaint);
    }
}
