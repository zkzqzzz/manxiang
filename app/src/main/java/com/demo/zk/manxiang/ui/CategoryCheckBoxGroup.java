package com.demo.zk.manxiang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.Category;
import com.demo.zk.manxiang.utils.LengthUnitUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houg on 2016/5/2.
 */
public class CategoryCheckBoxGroup extends GridLayout{

    private Context context;

    private LayoutInflater inflater;

    private List<CheckBox> checkBoxes = new ArrayList<CheckBox>();

    private int checkedIndex = -1;

    private List<Category> cats;


    public CategoryCheckBoxGroup(Context context) {
        super(context);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public CategoryCheckBoxGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public CategoryCheckBoxGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public  void init(List<Category> categories,CheckBoxCallback ck) {
        this.cats = categories;
        this.callback = ck;
        for (int i = 0; i < cats.size(); i++) {
            CheckBox checkBox = (CheckBox) inflater.inflate(R.layout.select_checkbox_layout, null);
            checkBox.setBackground(context.getResources().getDrawable(R.drawable.search_radio_button_2));
            checkBox.setTag(i);
            checkBox.setText(cats.get(i).getName());
            checkBoxes.add(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int index = (int) buttonView.getTag();
                    if (isChecked) {
                        int old = checkedIndex;
                        checkedIndex = index;
                        if (old != -1) {
                            checkBoxes.get(old).setChecked(false);
                        }
                        callback.onResponse(cats.get(checkedIndex));
                    } else {
                        if (checkedIndex == index) {
                           checkedIndex = -1;
                        }
                    }
                }
            });
            this.addView(checkBox, LengthUnitUtils.dp2px(context, 80), LengthUnitUtils.dp2px(context, 25));
        }
    }

    public void reset(){
        if(checkedIndex!=-1){
            checkBoxes.get(checkedIndex).setChecked(false);
        }
    }

    public Category get(){
        if(checkedIndex!=-1){
            cats.get(checkedIndex);
        }
        return null;
    }

    private CheckBoxCallback callback;

    public interface CheckBoxCallback{

        public void onResponse(Category vo);
    }
}