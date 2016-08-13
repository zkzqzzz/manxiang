package com.demo.zk.manxiang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.zk.manxiang.adapter.GuideViewPagerAdapter;
import com.demo.zk.manxiang.utils.ThreadValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houg on 2015/10/9.
 */

public class GuidePagerActivity extends BaseActivity {


    private ViewPager viewPager;

    private List<View> views;

    private int[] imgs ={R.mipmap.guide1,R.mipmap.guide2,R.mipmap.guide3,R.mipmap.guide4};



    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_guide_pager);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
       viewPager = (ViewPager)findViewById(R.id.viewpager);
        views = new ArrayList<View>();
        LayoutInflater inflater = LayoutInflater.from(this);
        for(int i=0;i<imgs.length;i++){
            View view = null;
            if(i<imgs.length-1)
                view = inflater.inflate(R.layout.guide_one_layout, null);
            else {
                view = inflater.inflate(R.layout.guide_two_layout, null);
                Button start = (Button)view.findViewById(R.id.start);
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ThreadValues.setFirst(getApplicationContext(), false);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
            ImageView img = (ImageView)view.findViewById(R.id.img);
            img.setImageDrawable(getResources().getDrawable(imgs[i]));
            views.add(view);
        }

        GuideViewPagerAdapter adapter = new GuideViewPagerAdapter(views);
        viewPager.setAdapter(adapter);
    }


}
