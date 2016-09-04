package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by WG on 2016/3/30.
 */
public class ServiceCommentRecyclerAdapter extends RecyclerView.Adapter {

    private List<ServiceDetail.Comment> datas = new ArrayList<ServiceDetail.Comment>();
    private Context context;

    public ServiceCommentRecyclerAdapter(Context context, List<ServiceDetail.Comment> datas) {
        this.context = context;
        this.datas.addAll(datas);
    }

    public List<ServiceDetail.Comment> getDatas() {
        return datas;
    }

    public void append(List<ServiceDetail.Comment> datas){
        this.datas.addAll(datas);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_comment_list_item, parent, false);
        return new  ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder holder = (ItemViewHolder)viewHolder;
        ServiceDetail.Comment comment = datas.get(position);
        ImageUtils.loadImage(context, comment.getUser_img(), holder.userIcon);
        holder.userName.setText(comment.getUser_nickname());
        holder.ratingBar.setRating(comment.getPoint());
        holder.content.setText(comment.getContent());
        holder.size.setText(comment.getParam_content());
        holder.time.setText(comment.getAdd_time());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView userIcon;
        TextView userName;
        RatingBar ratingBar;
        TextView content;
        TextView size;
        TextView time;

        public ItemViewHolder(View convertView) {
            super(convertView);
            userIcon = (RoundedImageView) convertView.findViewById(R.id.user_header);
            userName = (TextView) convertView.findViewById(R.id.user_name);
            ratingBar = (RatingBar) convertView.findViewById(R.id.rate_bar);
            content = (TextView) convertView.findViewById(R.id.content);
            size = (TextView) convertView.findViewById(R.id.param_content);
            time = (TextView) convertView.findViewById(R.id.date);
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

        }
    }

}
