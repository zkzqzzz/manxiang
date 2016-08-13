package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.SpecialRecyclerDetailActivity;
import com.demo.zk.manxiang.domain.Special;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.github.captain_miao.recyclerviewutils.BaseLoadMoreRecyclerAdapter;
import com.github.captain_miao.recyclerviewutils.common.ClickableViewHolder;
import com.github.captain_miao.recyclerviewutils.listener.OnRecyclerItemClickListener;

import java.util.List;


/**
 * Created by Administrator on 2016/3/28.
 */
public class SpecialMainAdapter extends BaseLoadMoreRecyclerAdapter<Special, SpecialMainAdapter.ItemViewHolder> implements OnRecyclerItemClickListener {


    private Context context;

    public SpecialMainAdapter(Context context, List<Special> data) {
        this.context = context;
        appendToList(data);
    }


    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wg_listview_special_mian, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(ItemViewHolder holder, int position) {
        ImageUtils.displayImage(context,getItem(position).getImg(),holder.icon);
        holder.title.setText(getItem(position).getName());
    }

    @Override
    public void onClick(View v, int position) {
         switch (v.getId()){
             case R.id.iv_special_item_image:
                 Intent intent  = new Intent(context, SpecialRecyclerDetailActivity.class);
                 intent.putExtra("special_id",getItem(position).getSpecial_id());
                 context.startActivity(intent);
                 break;
             default:break;
         }
    }

    public class ItemViewHolder extends ClickableViewHolder {
        public ImageView icon;
        public TextView title;

        public ItemViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.iv_special_item_image);
            title = (TextView)view.findViewById(R.id.iv_special_item_title);
            setOnRecyclerItemClickListener(SpecialMainAdapter.this);
            addOnItemViewClickListener();
            addOnViewClickListener(icon);
        }
    }


}