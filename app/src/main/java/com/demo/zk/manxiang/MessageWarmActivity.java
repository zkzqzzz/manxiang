package com.demo.zk.manxiang;

import android.os.Bundle;

/**
 * Created by Administrator on 2016/4/14.
 */
public class MessageWarmActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

    }
}
/*
public class MessageWarmActivity extends BaseActivity {

    private static final String WARM = "定时提醒";
    private static final int MAX_ITEM_COUNT = 2;
    private MessageAllAdapter mAdapter;


    @ViewInject(R.id.wg_header_back)
    private ImageButton back;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.wg_right_btn)
    private ImageButton more;

    @ViewInject(R.id.pullRefreshLayout)
    private PullRefreshLayout mPullRefreshLayout;

    @ViewInject(R.id.recyclerView)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.header_layout)
    private View headerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initData();

        initEvent();
    }

    private void initView() {
        setContentView(R.layout.wg_activity_message_all);
        ViewUtils.inject(this);
        title.setText(WARM);
    }

    private void initData() {
        mAdapter = new MessageAllAdapter(this, new ArrayList<MessageAllUnit>());

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        mRecyclerView.addOnScrollListener(mOnScrollListener);

        mPullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
        mPullRefreshLayout.setColor(getResources().getColor(R.color.progress_bar_color));
    }

    private void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getThis(), false,true);
                popupMenu.showPopupWindow(headerLayout);
            }
        });

        mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.addNewData(getAdapterData());
                        RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
                        mPullRefreshLayout.setRefreshing(false);
                        count = 0;
                        hasMore = true;
                    }
                }, 2000);
            }
        });

        mAdapter.setOnClickListener(new MessageAllAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MessageWarmActivity.this, "条目" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int count = 0;

    private boolean hasMore = true;

    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener() {

        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
          */
/*  if (!hasMore) {
                return;
            }
            count++;
            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
            if (state == LoadingFooter.State.Loading) {
                return;
            }
            RecyclerViewStateUtils.setFooterViewState(MessageWarmActivity.this, mRecyclerView, MAX_ITEM_COUNT, LoadingFooter.State.Loading, null);
            mAdapter.append(getAdapterData());
            if (count < 5)
                RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
            else {
                hasMore = false;
                RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.TheEnd);
            }*//*



        }
    };

    public List<MessageAllUnit> getAdapterData() {
        List<MessageAllUnit> data = new ArrayList<>();
        for (int i = 0; i < MAX_ITEM_COUNT; i++) {
            MessageAllUnit unit = new MessageAllUnit();
            unit.setState(MessageAllUnit.WARM);
            data.add(unit);
        }
        return data;
    }
}
*/
