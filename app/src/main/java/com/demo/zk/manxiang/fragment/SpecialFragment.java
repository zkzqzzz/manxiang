package com.demo.zk.manxiang.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.demo.zk.manxiang.BaseActivity;
import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.adapter.SpecialMainAdapter;
import com.demo.zk.manxiang.domain.CollectionSpecial;
import com.demo.zk.manxiang.domain.Special;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.presenter.SpecialPresenter;
import com.demo.zk.manxiang.ui.PopupMenu;
import com.demo.zk.manxiang.view.ISpecialView;
import com.github.captain_miao.recyclerviewutils.RefreshRecyclerView;
import com.github.captain_miao.recyclerviewutils.listener.RefreshRecyclerViewListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by HG on 2015/10/9.
 */

/*public class SpecialFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_layout,
                container, false);
        ViewUtils.inject(this, view);
        TextView mytext = (TextView) view.findViewById(R.id.my_test);
        mytext.setText("SpecialFragment");
        return view;
    }
}*/

public class SpecialFragment extends BaseFragment implements RefreshRecyclerViewListener,ISpecialView{
    private static final String SPECIAL = "专题";
    private static final String TAG = "SpecialFragment";
    private SpecialMainAdapter adapter;

    @ViewInject(R.id.wg_header_back)
    private ImageButton back;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.layout_header)
    private View headerLayout;

    @ViewInject(R.id.special_list)
    private RefreshRecyclerView specialListView;

    private SpecialPresenter presenter;

    private int PAGE_SIZE = 10;

    private int page = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_special, container, false);
        ViewUtils.inject(this, view);
        //设置返回按钮不可见
        view.findViewById(R.id.wg_header_back).setVisibility(View.INVISIBLE);
        //通用标题--专题
        title.setText(SPECIAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        specialListView.setLayoutManager(linearLayoutManager);

        adapter = new SpecialMainAdapter(getContext(),new ArrayList<Special>());
        specialListView.setAdapter(adapter);
        specialListView.setRecyclerViewListener(this);
        initData();
        return view;
    }

    private void initData() {
        presenter = new SpecialPresenter(this);
        page = 1;
        presenter.getList(page,PAGE_SIZE);
    }

    private PopupMenu popupMenu;

    @OnClick({R.id.wg_header_back,R.id.wg_right_btn})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wg_header_back:
                Log.i(TAG, "返回");
                break;
            case R.id.wg_right_btn:
                Log.i(TAG, "弹出菜单");
                //第一个false  是否有分享   第二个外部应用消息   第一true才考虑第二个
                popupMenu = new PopupMenu(getContext(), false,false);
                popupMenu.showPopupWindow(headerLayout);
                break;
            default:
                break;
        }
    }
    /**
     * RefreshRecyclerViewListener  接口实现
     * @param v The view that was clicked.
     * @param position
     */
    @Override
    public void onClick(View v, int position) {

    }

    @Override
    public void onRefresh() {
        page = 1;
        presenter.getList(page,PAGE_SIZE);
    }

    //加载更多
    @Override
    public void onLoadMore(int pagination, int pageSize) {
        if(adapter.hasMoreData()){
            page ++;
            presenter.getList(page,PAGE_SIZE);
        }else {
            specialListView.loadMoreComplete();
        }
    }

    /**
     * ISpecialView 接口实现
     * @param specials
     */
    @Override
    public void setSpecials(List<Special> specials) {
        if(adapter!=null&&page==1){
            specialListView.refreshComplete();
            adapter.clear();
            adapter.appendToList(specials);
            adapter.notifyDataSetChanged();
            specialListView.getRecyclerView().scrollToPosition(0);
            adapter.setHasMoreData(true);

        }else {
            if(specials==null||specials.size()==0){
                page = page - 1;
                adapter.setHasMoreData(false);
                adapter.showNoMoreDataView();
                specialListView.loadMoreComplete();
                return;
            }if(specials!=null&&specials.size()<PAGE_SIZE){
                adapter.appendToList(specials);
                adapter.notifyDataSetChanged();
                adapter.setHasMoreData(false);
                adapter.showNoMoreDataView();
            }else {
                adapter.appendToList(specials);
                adapter.notifyDataSetChanged();
                adapter.hideFooterView();
            }
//            Log.i("SP:",""+adapter.getItemCount());
            specialListView.loadMoreComplete();
        }
    }

    @Override
    public void setSpecialViewCollectionSearch(List<CollectionSpecial> data) {

    }

    @Override
    public void setSpecialCollectionList(List<CollectionSpecial> data) {

    }

    @Override
    public void setSpecialCollectionResult(Status data) {

    }

    @Override
    public void setSpecialCancelCollection(Status data) {

    }

}
