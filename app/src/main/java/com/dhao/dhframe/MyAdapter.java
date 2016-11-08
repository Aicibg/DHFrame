package com.dhao.dhframe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dhao.framelibrary.adapter.BaseRecycleAdapter;
import com.dhao.framelibrary.adapter.BaseViewHolder;

/**
 * Created by DongHao on 2016/11/8.
 * Description:
 */

public class MyAdapter extends BaseRecycleAdapter<String,MyAdapter.MyViewHolder> {


    @Override
    protected void bindView(MyViewHolder holder, int position) {
        holder.tvText.setText(getData().get(position));
        holder.btnButton.setText(getData().get(position));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==1){
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
        }else {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view1,parent,false));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 1;
        }
        return 2;
    }

    class MyViewHolder extends BaseViewHolder{
        TextView tvText;
        Button btnButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvText= (TextView) itemView.findViewById(R.id.textView2);
            btnButton= (Button) itemView.findViewById(R.id.button3);
        }
    }
}
