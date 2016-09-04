package com.demo.zk.manxiang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;


import com.demo.zk.manxiang.adapter.PainterViewPagerAdapter;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.domain.CollectionPainter;
import com.demo.zk.manxiang.domain.Painter;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.presenter.CollectionPainterPresenter;
import com.demo.zk.manxiang.presenter.PainterPresenter;
import com.demo.zk.manxiang.presenter.SharePresenter;
import com.demo.zk.manxiang.ui.PopupMenu;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.demo.zk.manxiang.view.ICollectionPainterView;
import com.demo.zk.manxiang.view.IPainterView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by houg on 2015/10/9.
 */
@ContentView(R.layout.activity_painter)
public class PainterActivity extends BaseActivity implements IPainterView, ICollectionPainterView {

    @ViewInject(R.id.painter_tabs)
    private RadioGroup mTabLayout;
    @ViewInject(R.id.home_tab)
    private RadioButton homeTab;

    @ViewInject(R.id.painter_pager)
    private ViewPager mViewPager;

    @ViewInject(R.id.user_icon)
    private RoundedImageView mPainterheader;

    @ViewInject(R.id.painter_name)
    private TextView mPainterName;

    @ViewInject(R.id.painter_sign)
    private TextView mSign;

    @ViewInject(R.id.expert)
    private TextView mExpert;

    @ViewInject(R.id.tra_count)
    private TextView mTraCount;

    @ViewInject(R.id.rate_bar)
    private RatingBar mRateBar;


    @ViewInject(R.id.background_img)
    private ImageView backgroundImg;

    @ViewInject(R.id.collect_btn)
    private Button collectBtn;

    @ViewInject(R.id.painter_header)
    private View headerLayout;

    private PainterViewPagerAdapter mAdapter;

    private PainterPresenter painterPresenter;

    private CollectionPainterPresenter collectionPainterPresenter;

    private long painter_id = 0;

    private Painter painter;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ViewUtils.inject(this);
        Intent intent = getIntent();
        painter_id = intent.getLongExtra("painter_id", 0);
        init();
    }

    private void init() {
        collectionPainterPresenter = new CollectionPainterPresenter(this);
        painterPresenter = new PainterPresenter(this);
        painterPresenter.getPainter(ThreadValues.getUserId(this), ThreadValues.getSid(this), painter_id);
        hud.show();
    }

    private PopupMenu popupMenu;

    @OnClick({R.id.wg_header_back, R.id.collect_btn, R.id.breif_btn, R.id.search_btn, R.id.wg_right_btn})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.wg_header_back:
                finish();
                break;
            case R.id.collect_btn:
                collectionPainterPresenter.getPainterCollectionResult(ThreadValues.getUserId(this), ThreadValues.getSid(this), painter_id,
                        painter.getIs_collection() == 1 ? 0 : 1);
                break;
            case R.id.breif_btn:
                //Intent intent = new Intent(this, PainterIntroduceActivity.class);
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("painter", painter);
                startActivity(intent);
                break;
            case R.id.search_btn:
                //Intent service = new Intent(this, PainterServiceActivity.class);
                Intent service = new Intent(this, LoginActivity.class);
                service.putExtra("painter_id", painter_id);
                startActivity(service);
                break;
            case R.id.wg_right_btn:
                popupMenu = new PopupMenu(this, true,false);
                popupMenu.setCallback(new PopupMenu.PopupMenuCallback() {
                    @Override
                    public void share() {
                        SharePresenter sharePresenter =new SharePresenter(getThis(),
                                StringUtils.absoluteUrl(painter.getImg()),painter.getNickname(),painter.getSignature(), RestAPI.SHARE_PAINTER_URL+painter.getPainter_id() );
                        sharePresenter.showDialog();
                    }
                });
                popupMenu.showPopupWindow(headerLayout);
                break;
            default:
                break;
        }
    }


    @Override
    public void setPainter(Painter painter) {
        this.painter = painter;
        hud.dismiss();
        ImageUtils.loadImage(this, painter.getImg(), mPainterheader);
        ImageUtils.loadImage(this, painter.getBackground_img(), backgroundImg);
        mPainterName.setText(painter.getNickname());
        mExpert.setText("(擅长:" + painter.getExpert() + ")");
        mSign.setText(painter.getSignature());
        mTraCount.setText("交易量:" + painter.getTransaction_count());
        mRateBar.setRating(painter.getPoint());
        mAdapter = new PainterViewPagerAdapter(this.getSupportFragmentManager(), this, painter_id);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_tab:
                        if (mViewPager.getCurrentItem() != 0)
                            mViewPager.setCurrentItem(0);
                        break;
                    case R.id.all_service_tab:
                        if (mViewPager.getCurrentItem() != 1)
                            mViewPager.setCurrentItem(1);
                        break;
                    case R.id.new_service_tab:
                        if (mViewPager.getCurrentItem() != 2)
                            mViewPager.setCurrentItem(2);
                        break;
                    case R.id.comment_tab:
                        if (mViewPager.getCurrentItem() != 3)
                            mViewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });
        homeTab.setChecked(true);
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
        if (painter.getIs_collection() == 1) {
            collectBtn.setText("取消收藏");
        } else {
            collectBtn.setText("收藏");
        }

    }

    @Override
    public void setPainters(List<Painter> painters) {

    }

    @Override
    public void setCollectionPainterList(List<CollectionPainter> data) {

    }

    @Override
    public void setPainterCollectionResult(Status data) {
        painter.setIs_collection(data.getStatus());
        if (painter.getIs_collection() == 1) {
            collectBtn.setText("取消收藏");
        } else {
            collectBtn.setText("收藏");
        }
    }

    @Override
    public void setPainterCollectionSearch(List<CollectionPainter> data) {

    }

    @Override
    public void setPainterCancelCollection(Status data) {

    }
}
