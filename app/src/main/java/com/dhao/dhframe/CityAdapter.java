package com.dhao.dhframe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dhao.framelibrary.adapter.BaseRecycleAdapter;

/**
 * Created by DongHao on 2016/11/9.
 * Description:
 */

public class CityAdapter extends BaseRecycleAdapter<CityBean,CityAdapter.CityViewHolder> {

    @Override
    protected void bindView(CityViewHolder holder, int position) {
          holder.tvCity.setText(getData().get(position).getCity());
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city,parent,false);
        return new CityViewHolder(view);
    }

    class CityViewHolder extends RecyclerView.ViewHolder{
       TextView tvCity;
       public CityViewHolder(View itemView) {
           super(itemView);
           tvCity= (TextView) itemView.findViewById(R.id.tv_city);
       }
   }
}
