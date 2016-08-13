package com.demo.zk.manxiang.adapter;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by houg on 2015/11/2.
 */
public class GuideViewPagerAdapter extends PagerAdapter {

    private List<View> views;

    public GuideViewPagerAdapter(List<View> views) {
        this.views = views;
    }

  /*  @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView(views.get(position));
        super.destroyItem(container, position, object);
    }
*/

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(views.get(position));
    }

    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(View  container, int position) {
        ((ViewPager) container).addView(views.get(position), 0);
        return views.get(position);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
