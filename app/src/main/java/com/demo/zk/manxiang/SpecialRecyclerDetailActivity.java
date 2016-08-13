package com.demo.zk.manxiang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.domain.Banner;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.domain.SpecialDetail;
import com.demo.zk.manxiang.ui.PopupMenu;
import com.demo.zk.manxiang.utils.ImageUtils;
import com.demo.zk.manxiang.utils.StringUtils;
import com.github.captain_miao.recyclerviewutils.EndlessRecyclerOnScrollListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.List;


/**
 * Created by WG on 2016/3/30.
 */
@ContentView(R.layout.wg_activity_special_detail)
public class SpecialRecyclerDetailActivity extends BaseActivity  {
    private static final String SPECIAL = "专题";

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        title.setText(SPECIAL);

    }
}
/*
@ContentView(R.layout.wg_activity_special_detail)
public class SpecialRecyclerDetailActivity extends BaseActivity implements ISpecialDetailView {

    private static final String SPECIAL = "专题";
    private static final String TAG = "SpecialRecyclerDetailActivity";

    private boolean isGrid = false;

    @ViewInject(R.id.special_details_list)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.refreshLayout)
    private PullRefreshLayout mRefreshLayout;

    @ViewInject(R.id.layout_header)
    private View headerLayout;

    private SpecialRecyclerDetailAdapter adapter;

    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;

    private ImageView mSpecialImg;
    private TextView mSpecialName;
    private TextView mSpecialDesc;

    private SpecialDetailPresenter presenter;

    private long special_id;

    private SpecialDeatailsHeader<Banner> header;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.wg_collect_btn)
    private ImageButton collectBtn;

    private int PAGE_SIZE = 10;
    private int page = 1;

    @ViewInject(R.id.wg_right_btn)
    private ImageButton more;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        title.setText(SPECIAL);
        init();

    }

    private void init() {

        Intent intent = getIntent();
        special_id = intent.getLongExtra("special_id", 0);
        presenter = new SpecialDetailPresenter(this);
        if (TextUtils.isEmpty(ThreadValues.getSid(this))) {
            presenter.getDetail(special_id);
        } else {
            presenter.getDetail(ThreadValues.getUserId(this), ThreadValues.getSid(this), special_id);
        }
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        mRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
        mRefreshLayout.setColor(getResources().getColor(R.color.progress_bar_color));
        mRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (TextUtils.isEmpty(ThreadValues.getSid(getApplicationContext()))) {
                    presenter.getDetail(special_id);
                } else {
                    presenter.getDetail(ThreadValues.getUserId(getApplicationContext()), ThreadValues.getSid(getApplicationContext()), special_id);
                }
            }
        });

    }

    private int is_collection;

    private SpecialDetail special;

    @Override
    public void setSpecialDetail(SpecialDetail specialDetail) {
        special = specialDetail;
        is_collection = specialDetail.getIs_collection();
        if (adapter != null) {
            mRefreshLayout.setRefreshing(false);
        }
        isGrid = specialDetail.getStyle_type()==2;
        adapter = new SpecialRecyclerDetailAdapter(this, specialDetail.getServices(), isGrid);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        if(!isGrid){
           // DividerItemDecorationForGrid item =new DividerItemDecorationForGrid(this);
            //mRecyclerView.addItemDecoration(item);
            mRecyclerView.addItemDecoration(new DividerItemDecorationForList(this, LinearLayoutManager.VERTICAL));
        }
        mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(getGridLayoutManager(isGrid));
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        initHeaderContent(specialDetail);
        //初始化收藏状态
        if(is_collection ==1){
            collectBtn.setImageResource(R.mipmap.tabbar_home_checked);
        }else {
            collectBtn.setImageResource(R.mipmap.tabbar_home);
        }

    }

    @Override
    public void setSpecialServices(List<PainterService> services) {
        if (services != null && services.size() == 0) {
            page = page - 1;
            RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.TheEnd);
            return;
        }
        adapter.append(services);
        adapter.notifyDataSetChanged();
        if (services.size() < PAGE_SIZE) {
            RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.TheEnd);
        } else {
            RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
        }
    }

    @Override
    public void setCollectionResult(Status data) {
        is_collection = data.getStatus();
        if(is_collection ==1){
            collectBtn.setImageResource(R.mipmap.tabbar_home_checked);
        }else {
            collectBtn.setImageResource(R.mipmap.tabbar_home);
        }
    }

    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener() {

        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
            if (state == LoadingFooter.State.Loading) {
                return;
            }
            RecyclerViewStateUtils.setFooterViewState(SpecialRecyclerDetailActivity.this, mRecyclerView, PAGE_SIZE, LoadingFooter.State.Loading, null);
            page++;
            presenter.getServices(special_id, page, PAGE_SIZE);

        }
    };


    //为RecyclerView设置专题头
    private void initHeaderContent(SpecialDetail specialDetail) {
        header = new SpecialDeatailsHeader<Banner>(this);
        ImageUtils.loadImage(this, specialDetail.getImg(), mSpecialImg);
        mSpecialName.setText(specialDetail.getName());
        mSpecialDesc.setText(specialDetail.getDescription());
        RecyclerViewUtils.setHeaderView(mRecyclerView, header);
    }

    private GridLayoutManager getGridLayoutManager(boolean isGrid) {
        GridLayoutManager manager = new GridLayoutManager(this, isGrid ? 2 : 1, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) mRecyclerView.getAdapter(), manager.getSpanCount()));
        return manager;
    }
    private PopupMenu popupMenu;
    @OnClick({R.id.wg_header_back, R.id.wg_special_switch, R.id.wg_right_btn,R.id.wg_collect_btn})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wg_header_back:
                this.finish();
                break;
            case R.id.wg_collect_btn:
                presenter.getCollectionResult(ThreadValues.getUserId(this), ThreadValues.getSid(this), special_id, is_collection == 1 ? 0 : 1);
                break;
            case R.id.wg_right_btn:
                popupMenu = new PopupMenu(this, true,false);
                popupMenu.setCallback(new PopupMenu.PopupMenuCallback() {
                    @Override
                    public void share() {
                        SharePresenter sharePresenter =new SharePresenter(getBaseContext(),
                                StringUtils.absoluteUrl(special.getImg()),special.getName(),special.getDescription(), RestAPI.SHARE_SPECIAL_URL+special.getSpecial_id() );
                        sharePresenter.showDialog();
                    }
                });
                popupMenu.showPopupWindow(headerLayout);
                break;
            default:
                break;
        }
    }

    public class SpecialDeatailsHeader<Banner> extends RelativeLayout {

        public BannerSlideShowView<Banner> slideShowView;

        public SpecialDeatailsHeader(Context context) {
            super(context);
            init(context);
        }

        public SpecialDeatailsHeader(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public SpecialDeatailsHeader(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        public void init(Context context) {
            View headerView = inflate(context, R.layout.special_details_recyclerview_header, this);
            mSpecialImg = (ImageView) headerView.findViewById(R.id.special_img);
            mSpecialName = (TextView) headerView.findViewById(R.id.special_recy_header_title);
            mSpecialDesc = (TextView) headerView.findViewById(R.id.special_recy_header_content);
        }
    }

}
*/
