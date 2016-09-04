package com.demo.zk.manxiang.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


import com.demo.zk.manxiang.fragment.BaseFragment;
import com.demo.zk.manxiang.fragment.ServiceCommentFragment;
import com.demo.zk.manxiang.fragment.ServiceDetailsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houg on 2015/11/2.
 */
public class ServiceDetailsViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    private String[] tabTitles ={"图文详情","评价"};

    public ServiceDetailsViewPagerAdapter(FragmentManager fm, Context context,long service_id,long painter_id,String content) {
        super(fm);
        fragments = new ArrayList<BaseFragment>();
        fragments.add(ServiceDetailsFragment.newInstance(service_id,painter_id,content));
        fragments.add(ServiceCommentFragment.newInstance(service_id));

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
