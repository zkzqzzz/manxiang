package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.SpecialSelectedGoodsUnit;

import java.util.List;

/**
 * Created by WG on 2016/4/6.
 */
public class SpecialRecyclerSelectedGoodsAdapter extends RecyclerView.Adapter<SpecialRecyclerSelectedGoodsAdapter.MyViewHolder> {

    private Context context;
    private List<SpecialSelectedGoodsUnit> list;

    public SpecialRecyclerSelectedGoodsAdapter(Context context,List<SpecialSelectedGoodsUnit> list) {
        this.context = context;
        this.list = list;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wg_special_selected_goods_item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (list.get(position).getImage() != null) {
            holder.image.setImageBitmap(list.get(position).getImage());
        }
        holder.content.setText(list.get(position).getContent());
        holder.discountCost.setText(String.format("￥%s", list.get(position).getDiscount()));
        holder.originalCost.setText(String.format("￥%s", list.get(position).getOriginal()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<SpecialSelectedGoodsUnit> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout item;
        public ImageView image;
        public TextView content;
        public TextView discountCost;
        public TextView originalCost;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.ll_special_item);
            image = (ImageView) itemView.findViewById(R.id.iv_special_item_image);
            content = (TextView) itemView.findViewById(R.id.tv_special_item_content);
            discountCost = (TextView) itemView.findViewById(R.id.tv_special_item_discount);
            originalCost = (TextView) itemView.findViewById(R.id.tv_special_item_original);
        }
    }
}
