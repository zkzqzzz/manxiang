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
public class MainViewPageAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    private String[] tabTitles = {"逛逛","找画家","我的"};

    private List<BaseFragment>  fragments = new ArrayList<BaseFragment>();

    private Context context;

    public MainViewPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
          fragments.add(new BrowseFragment());
          fragments.add(new SpecialFragment());
          fragments.add(new MineFragment());
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
