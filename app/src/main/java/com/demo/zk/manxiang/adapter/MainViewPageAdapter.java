package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.demo.zk.manxiang.fragment.BaseFragment;
import com.demo.zk.manxiang.fragment.BrowseFragment;
import com.demo.zk.manxiang.fragment.MineFragment;
import com.demo.zk.manxiang.fragment.SpecialFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by houg on 2015/10/15.
 */

//主界面所需的fragmentpage适配器（就是fragment+viewpager）
public class MainViewPageAdapter extends FragmentPagerAdapter{

    //页数
    final int PAGE_COUNT = 3;

    private String[] tabTitles = {"逛逛","找画家","我的"};

    private List<BaseFragment> fragments = new ArrayList<BaseFragment>();

    private Context context;

    public MainViewPageAdapter(FragmentManager fm,Context context) {
        super(fm);
        //相当于拿到了上下文
        this.context=context;
        fragments.add(new BrowseFragment());  //逛逛
        fragments.add(new SpecialFragment()); //专题
        fragments.add(new MineFragment());    //我的
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

}

