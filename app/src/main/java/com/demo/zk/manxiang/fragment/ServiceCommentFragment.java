package com.demo.zk.manxiang.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cundong.recyclerview.EndlessRecyclerOnScrollListener;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.HeaderSpanSizeLookup;

import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.adapter.DividerItemDecorationForGrid;
import com.demo.zk.manxiang.adapter.ServiceCommentRecyclerAdapter;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.presenter.ServiceCommentPresenter;
import com.demo.zk.manxiang.utils.RecyclerViewStateUtils;
import com.demo.zk.manxiang.view.IServiceCommentView;
import com.demo.zk.manxiang.widget.LoadingFooter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by houg on 2016/4/5.
 */
public class ServiceCommentFragment extends BaseFragment implements IServiceCommentView {

    @ViewInject(R.id.scroll_view)
    private RecyclerView mRecyclerView;

    private long service_id;

    private ServiceCommentRecyclerAdapter mAdapter;

    private ServiceCommentPresenter presenter;

    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;

    private final int PAGE_SIZE = 10;

    private int page = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_service_comment, container, false);
           ViewUtils.inject(this, view);
           service_id = getArguments().getLong("service_id",0);
           presenter = new ServiceCommentPresenter(this);
           page = 1;
           presenter.getServiceComment(service_id,PAGE_SIZE,page);
           return view;
    }

    public static ServiceCommentFragment newInstance(long service_id) {
        ServiceCommentFragment pageFragment = new ServiceCommentFragment();
        Bundle args = new Bundle();
        args.putLong("service_id",service_id);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener() {

        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
            if(state == LoadingFooter.State.Loading) {
                return;
            }
            RecyclerViewStateUtils.setFooterViewState(getActivity(), mRecyclerView, PAGE_SIZE, LoadingFooter.State.Loading, null);
            page ++;
            presenter.getServiceComment(service_id, PAGE_SIZE, page);
        }
    };


    private GridLayoutManager getGridLayoutManager(){
        GridLayoutManager  manager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) mRecyclerView.getAdapter(), manager.getSpanCount()));
        return manager;
    }

    @Override
    public void setServiceComment(List<ServiceDetail.Comment> comments) {
        if(mAdapter==null||page==1){
            mAdapter = new ServiceCommentRecyclerAdapter(getContext(),comments);
            mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter( mAdapter);
            mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
            mRecyclerView.addItemDecoration(new DividerItemDecorationForGrid(getContext()));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.addOnScrollListener(mOnScrollListener);
            return;
        }
        if(comments!=null&&comments.size()==0){
            page = page - 1;
            RecyclerViewStateUtils.setFooterViewState( mRecyclerView, LoadingFooter.State.TheEnd);
            return;
        }
        mAdapter.append(comments);
        if(comments.size()<PAGE_SIZE){
            RecyclerViewStateUtils.setFooterViewState( mRecyclerView, LoadingFooter.State.TheEnd);
        }else {
            RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
        }
    }
}
