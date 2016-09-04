package com.demo.zk.manxiang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.Category;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.utils.LengthUnitUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public class CategoryCheckBoxGroupService extends GridLayout {

    private Context context;

    private LayoutInflater inflater;

    private List<CheckBox> checkBoxes = new ArrayList<CheckBox>();

    private int checkedIndex = -1;

    private List<ServiceDetail.ServiceParam> cats;


    public CategoryCheckBoxGroupService(Context context) {
        super(context);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public CategoryCheckBoxGroupService(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public CategoryCheckBoxGroupService(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void init(List<ServiceDetail.ServiceParam> categories, CheckBoxCallback ck) {
        this.cats = categories;
        this.callback = ck;
        for (int i = 0; i < cats.size(); i++) {
            CheckBox checkBox = (CheckBox) inflater.inflate(R.layout.select_checkbox_layout, null);
            checkBox.setTag(i);
            checkBox.setText(cats.get(i).getPaint_type_name());
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
                        callback.onResponse(cats.get(checkedIndex));
                    } else {
                        if (checkedIndex == index) {
                            checkedIndex = -1;
                            callback.onResponse(null);
                        }
                    }
                }
            });
            this.addView(checkBox, LengthUnitUtils.dp2px(context, 100), LengthUnitUtils.dp2px(context, 35));
        }
    }

    public void setInitChecked(int checkedIndex) {
        if (checkedIndex >= 0 && checkedIndex < checkBoxes.size()) {
            checkBoxes.get(checkedIndex).setChecked(true);
        }
    }

    public void reset() {
        if (checkedIndex != -1) {
            checkBoxes.get(checkedIndex).setChecked(false);
        }
    }

    public Category get() {
        if (checkedIndex != -1) {
            cats.get(checkedIndex);
        }
        return null;
    }

    private CheckBoxCallback callback;

    public interface CheckBoxCallback {

        public void onResponse(ServiceDetail.ServiceParam vo);
    }
}