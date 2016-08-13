package com.demo.zk.manxiang.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.demo.zk.manxiang.LoginActivity;
import com.demo.zk.manxiang.MainActivity;
import com.demo.zk.manxiang.MessageCenterActivity;
import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.domain.Banner;
import com.demo.zk.manxiang.domain.Category;
import com.demo.zk.manxiang.view.IBannerView;
import com.demo.zk.manxiang.view.IBrowseView;
import com.demo.zk.manxiang.wxpay.SeckillActivity;
import com.hyphenate.util.ImageUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

;import java.util.List;

/**
 * Created by HG on 2015/10/9.
 */
public class BrowseFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_layout,
                container, false);
        ViewUtils.inject(this, view);
        TextView mytext = (TextView) view.findViewById(R.id.my_test);
        mytext.setText("BrowseFragment");
        return view;
    }
}
/*public class BrowseFragment extends BaseFragment implements IBrowseView,IBannerView {


    private static final String TAG = "BrowseFragment";

    @ViewInject(R.id.tab_group)
    private RadiobuttonTabGroup mTabLayout;

    @ViewInject(R.id.browse_pager)
    private ViewPager mViewPager;

    @ViewInject(R.id.slide_wiew)
    private BannerSlideShowView mSlideWiew;

    @ViewInject(R.id.dashi_img)
    private ImageView dashi_img;

    @ViewInject(R.id.join_img)
    private ImageView join_img;

    @ViewInject(R.id.miaos_desc)
    private TextView miaos_desc;

    @ViewInject(R.id.miaos_img)
    private ImageView miaos_img;



    private BrowseViewPagerAdapter mAdapter;

    private BrowsePresenter browsePresenter;

    private BannerPresenter bannerPresenter ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse,
                container, false);
        ViewUtils.inject(this, view);
        init();
        return view;
    }

    private void init(){
        browsePresenter = new BrowsePresenter(this);
        browsePresenter.getBanners(21);
        browsePresenter.getBanners(22);
        browsePresenter.getBanners(23);
        bannerPresenter = new BannerPresenter(this);
        browsePresenter.getCat();
        bannerPresenter.getBanners(1);
        hud.show();
    }






    @OnClick({R.id.seckill_btn,R.id.left_btn,R.id.right_btn,R.id.search_btn,R.id.becomme,R.id.need,R.id.take_photo})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seckill_btn:
                Intent intent = new Intent(getContext(), SeckillActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.left_btn:
                Intent intent2 = new Intent(getContext(), WatchServiceActivity.class);
                getContext().startActivity(intent2);
                break;
            case R.id.search_btn:
                Intent intent3 = new Intent(getContext(), SearchServiceActivity.class);
                getContext().startActivity(intent3);
                break;
            case R.id.becomme:
                if (TextUtils.isEmpty(ThreadValues.getSid(getContext()))) {
                    Intent login = new Intent(getContext(), LoginActivity.class);
                    startActivity(login);
                    return;
                }
                Intent intent4 = new Intent(getContext(), ArtistActivity.class);
                getContext().startActivity(intent4);
                break;
            case R.id.need:
                Intent intent5 = new Intent(getContext(), WatchServiceActivity.class);
                getContext().startActivity(intent5);
                break;
            case R.id.take_photo:
                MainActivity activity = (MainActivity) getActivity();
                activity.showDailog();
                break;
            case R.id.right_btn:
                Intent message = new Intent(getContext(), MessageCenterActivity.class);
                startActivity(message);
                break;
            default:break;
        }
    }



    @Override
    public void setCategories(List<Category> cats) {
        hud.dismiss();
        mAdapter = new BrowseViewPagerAdapter(getActivity().getSupportFragmentManager(), getContext(),cats);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.init(cats);
        mTabLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = (int) group.findViewById(checkedId).getTag();
                if (mViewPager.getCurrentItem() != index)
                    mViewPager.setCurrentItem(index);
            }
        });
        mTabLayout.setChecked(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = (RadioButton) mTabLayout.getChildAt(position);
                if (!radioButton.isChecked()) {
                    radioButton.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setBanners(int cat_id, List<Banner> banners) {
          if(banners==null||banners.size()==0){
              return;
          }
          Banner banner = banners.get(0);
          switch (cat_id){
              case 21:
                   miaos_desc.setText(banner.getName());
                   ImageUtils.loadImage(getContext(),banner.getImg(),miaos_img);
                  break;
              case 22:
                  ImageUtils.loadImage(getContext(),banner.getImg(),dashi_img);
                  dashi_img.setOnClickListener(new BannerOnClickListener(banner));
                  break;
              case 23:
                  ImageUtils.loadImage(getContext(),banner.getImg(),join_img);
                  join_img.setOnClickListener(new BannerOnClickListener(banner));
                  break;
              default:break;
          }
    }

   public class BannerOnClickListener implements View.OnClickListener{
       private Banner banner;

       public BannerOnClickListener(Banner banner) {
           this.banner = banner;
       }

       @Override
       public void onClick(View v) {
           if (banner.getType() == 1) {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(banner.getUrl()));
               getContext().startActivity(intent);
           } else if (banner.getType() == 2) {
               Intent intent = new Intent(getContext(), ServiceDetailsActivity.class);
               intent.putExtra("service_id", banner.getValue_id());
               getContext().startActivity(intent);
           } else if (banner.getType() == 3) {
               Intent intent = new Intent(getContext(), PainterActivity.class);
               intent.putExtra("painter_id", banner.getValue_id());
               getContext().startActivity(intent);
           } else if (banner.getType() == 4) {
               Intent intent = new Intent(getContext(), SpecialRecyclerDetailActivity.class);
               intent.putExtra("special_id", banner.getValue_id());
               getContext().startActivity(intent);
           }
       }
   }

    @Override
    public void setBanners(List<Banner> banners) {
        mSlideWiew.initData(banners, new BannerSlideShowView.BannerCallback<Banner>() {
            @Override
            public void initImage(Banner banner, ImageView view) {
                ImageUtils.loadImage(getContext(), banner.getImg(), view);
            }

            @Override
            public void onClick(Banner banner) {
                if (banner.getType() == 1) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(banner.getUrl()));
                    getContext().startActivity(intent);
                } else if (banner.getType() == 2) {
                    Intent intent = new Intent(getContext(), ServiceDetailsActivity.class);
                    intent.putExtra("service_id", banner.getValue_id());
                    getContext().startActivity(intent);
                } else if (banner.getType() == 3) {
                    Intent intent = new Intent(getContext(), PainterActivity.class);
                    intent.putExtra("painter_id", banner.getValue_id());
                    getContext().startActivity(intent);
                } else if (banner.getType() == 4) {
                    Intent intent = new Intent(getContext(), SpecialRecyclerDetailActivity.class);
                    intent.putExtra("special_id", banner.getValue_id());
                    getContext().startActivity(intent);
                }

            }
        });
    }


}*/
