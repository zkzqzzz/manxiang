package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.ServiceDetailsActivity;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.demo.zk.manxiang.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by WG on 2016/3/30.
 */
public class SpecialRecyclerDetailAdapter extends RecyclerView.Adapter {

    private static final String TAG = "SpecialRecyclerDetailAdapter";
    private List<PainterService> datas = new ArrayList<PainterService>();
    private Context context;
    private boolean isGrid;


    public SpecialRecyclerDetailAdapter(Context context, List<PainterService> datas, boolean isGrid) {
        this.context = context;
        this.isGrid = isGrid;
        this.datas.addAll(datas);
    }


    public List<PainterService> getDatas() {
        return datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
                .inflate(this.isGrid ? R.layout.wg_recycler_item_two : R.layout.wg_recycler_item_one, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemView = (ItemViewHolder) holder;
        ImageUtils.displayImage(context, datas.get(position).getImg(), itemView.detailImage);
        itemView.detailContent.setText(datas.get(position).getName());
        itemView.detailPrice.setText("￥ " + datas.get(position).getPrice());
        ImageUtils.loadImage(context, StringUtils.isNotEmpty(datas.get(position).getService_img()) ? datas.get(position).getService_img() : datas.get(position).getImg(), itemView.detailImage);
        itemView.detailContent.setText(StringUtils.isNotEmpty(datas.get(position).getService_name()) ? datas.get(position).getService_name() : datas.get(position).getName());
        itemView.detailPrice.setText("￥ "+datas.get(position).getPrice());
        itemView.detailNumbers.setText(String.valueOf(datas.get(position).getPraise_count()));
        itemView.view.setOnClickListener(new RecyclerOnClickListener(position));

    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public void addNewDatas(List<PainterService> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
    }

    @Override
    public long getItemId(int position) {
        return datas.get(position).getService_id();
    }

    public void append(List<PainterService> datas) {
        this.datas.addAll(datas);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        LinearLayout detail;
        ImageView detailImage;
        TextView detailContent;
        TextView detailPrice;
        ImageView detailStar;
        TextView detailNumbers;

        View view;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            detail = (LinearLayout) itemView.findViewById(R.id.ll_special_detail);
            detailImage = (ImageView) itemView.findViewById(R.id.iv_special_detail_image);
            detailContent = (TextView) itemView.findViewById(R.id.tv_special_detail_content);
            detailPrice = (TextView) itemView.findViewById(R.id.tv_special_detail_price);
            detailStar = (ImageView) itemView.findViewById(R.id.iv_special_detail_star);
            detailNumbers = (TextView) itemView.findViewById(R.id.tv_special_detail_numbers);
        }
    }

    public class RecyclerOnClickListener implements View.OnClickListener{

        private int position;

        public RecyclerOnClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            onClick(v,position);
        }

        public void onClick(View v,int position) {
            Intent detailPage = new Intent(context,  ServiceDetailsActivity.class);
            detailPage.putExtra("service_id",datas.get(position).getService_id());
            context.startActivity(detailPage);
        }
    }



}
