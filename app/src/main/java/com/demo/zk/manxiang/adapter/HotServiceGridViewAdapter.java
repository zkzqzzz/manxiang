package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by HG on 2015/10/27.
 */
public class HotServiceGridViewAdapter extends BaseAdapter{

    private LayoutInflater inflater;

    private Context context;

    private List<PainterService> datas;


    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            notifyDataSetChanged();
        }

        ;
    };

    public HotServiceGridViewAdapter(Context context, List<PainterService> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }


    public void update(List<PainterService> datas){
        if (datas != null) {
            this.datas = datas;
            handler.sendEmptyMessage(0);
        }
    }

    @Override
    public int getCount() {
        if(datas==null)
            return 0;
        return datas.size();
    }

    @Override
    public PainterService getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.painter_home_item_4_item, null);
            ViewUtils.inject(holder, convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PainterService service = datas.get(position);
        ImageUtils.loadImage(context, service.getImg(), holder.serviceImg);
        holder.serivceName.setText(service.getName());
        holder.price.setText("￥ "+service.getPrice());
        holder.price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.d_price.setText("￥ "+service.getDiscount_price());
        return convertView;
    }

     class ViewHolder {

         @ViewInject(R.id.img)
         public ImageView serviceImg;

        @ViewInject(R.id.name)
        public TextView serivceName;

        @ViewInject(R.id.price)
        public TextView price;

         @ViewInject(R.id.discount_price)
         public TextView d_price;


    }


}
