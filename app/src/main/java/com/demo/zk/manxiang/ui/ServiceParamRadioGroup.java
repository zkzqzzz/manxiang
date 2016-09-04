package com.demo.zk.manxiang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.RadioButton;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.utils.LengthUnitUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houg on 2016/5/2.
 */
public class ServiceParamRadioGroup extends GridLayout{

    private Context context;

    private LayoutInflater inflater;

    private List<RadioButton>  radioButtons = new ArrayList<RadioButton>();

    private int checkedIndex = -1;

    private List<ServiceDetail.ServiceParam.Params> params = new ArrayList<ServiceDetail.ServiceParam.Params>();


    public ServiceParamRadioGroup(Context context) {
        super(context);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public ServiceParamRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public ServiceParamRadioGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public  void init(List<ServiceDetail.ServiceParam.Params> paramValues,final RadioGroupCallback callback){
        this.params = paramValues;
        checkedIndex = -1;
        this.removeAllViews();
        radioButtons.clear();
        for(int i=0;i<params.size();i++) {
            RadioButton radioButton = (RadioButton) inflater.inflate(R.layout.service_radio_layout, null);
            radioButton .setTag(i);
            radioButton .setText(params.get(i).getParam_name());
            radioButtons.add(radioButton);
            radioButton .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int index = (int) buttonView.getTag();

                    if (isChecked) {
                        int old = checkedIndex;
                        checkedIndex = index;
                        if (old != -1) {
                            radioButtons.get(old).setChecked(false);
                        }
                        callback.onCheckedChenge();
                    } else {
                        if (checkedIndex == index) {
                            checkedIndex = -1;
                        }
                    }
                }
            });
            this.addView(radioButton, LengthUnitUtils.dp2px(context, 95), LengthUnitUtils.dp2px(context, 25));
        }
    }

    public void  setCheckedIndex(int index){
        if(radioButtons.size()>0){
            radioButtons.get(index).setChecked(true);
        }
    }

    public ServiceDetail.ServiceParam.Params  get(){
        if(checkedIndex==-1)
            return  null;
        return params.get(checkedIndex);
    }

    private RadioGroupCallback callback;

    public  interface  RadioGroupCallback{

        public void  onCheckedChenge();
    }

}