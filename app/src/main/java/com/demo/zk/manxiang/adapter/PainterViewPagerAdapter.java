package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


import com.demo.zk.manxiang.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houg on 2015/11/2.
 */
public class PainterViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    private String[] tabTitles ={"首页","全部服务","新品上架","评论"};

    public PainterViewPagerAdapter(FragmentManager fm, Context context,long painter_id) {
        super(fm);
        fragments = new ArrayList<BaseFragment>();
/*        fragments.add(PainterHomeFragment.newInstance(painter_id));
        fragments.add(PainterAllServiceFragment.newInstance(painter_id));
        fragments.add(PainterNewServiceFragment.newInstance(painter_id));
        fragments.add(PainterCommentFragment.newInstance(painter_id));*/
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
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
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
