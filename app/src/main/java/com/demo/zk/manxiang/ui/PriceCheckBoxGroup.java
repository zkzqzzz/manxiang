package com.demo.zk.manxiang.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.PriceVo;
import com.demo.zk.manxiang.utils.LengthUnitUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houg on 2016/5/2.
 */
public class PriceCheckBoxGroup extends GridLayout{

    private Context context;

    private LayoutInflater inflater;

    private List<CheckBox> checkBoxes = new ArrayList<CheckBox>();

    private int checkedIndex = -1;

    private List<PriceVo> priceVos;


    public PriceCheckBoxGroup(Context context) {
        super(context);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public PriceCheckBoxGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public PriceCheckBoxGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public  void init(List<PriceVo> vos, CheckBoxCallback ck){
        this.priceVos = vos;
        this.callback = ck;
        for(int i=0;i<vos.size();i++) {
            CheckBox checkBox = (CheckBox) inflater.inflate(R.layout.select_checkbox_layout, null);
            checkBox.setBackground(context.getResources().getDrawable(R.drawable.search_radio_button_0));
            checkBox.setTag(i);
            checkBox.setText(vos.get(i).getName());
            checkBoxes.add(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int index = (int) buttonView.getTag();
                    if (isChecked) {
                        if (checkedIndex != -1) {
                            checkBoxes.get(checkedIndex).setChecked(false);
                        }
                        checkedIndex = index;
                        callback.onResponse(priceVos.get(checkedIndex));
                    } else {
                        if (checkedIndex == index) {
                            checkedIndex = -1;
                            callback.onResponse(null);
                        }
                    }
                }
            });
            this.addView(checkBox, LengthUnitUtils.dp2px(context,80), LengthUnitUtils.dp2px(context,25));
        }
    }

    public void reset(){
        if(checkedIndex!=-1){
            checkBoxes.get(checkedIndex).setChecked(false);
        }
    }

    public PriceVo get(){
        if(checkedIndex!=-1){
            priceVos.get(checkedIndex);
        }
        return null;
    }

    private CheckBoxCallback callback;

    public interface CheckBoxCallback{

        public void onResponse(PriceVo vo);
    }
}