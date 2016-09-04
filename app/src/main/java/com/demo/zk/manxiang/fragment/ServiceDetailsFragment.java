package com.demo.zk.manxiang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.demo.zk.manxiang.PainterActivity;
import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.ServiceDetailsActivity;
import com.demo.zk.manxiang.adapter.HotServiceGridViewAdapter;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.presenter.PainterServicePresenter;
import com.demo.zk.manxiang.ui.CustomGridView;
import com.demo.zk.manxiang.view.IPainterServiceView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by houg on 2016/4/5.
 */
public class ServiceDetailsFragment extends BaseFragment implements IPainterServiceView {

    @ViewInject(R.id.web_view)
    private WebView webView;

    @ViewInject(R.id.grid_view)
    private CustomGridView gridView;

    @ViewInject(R.id.tv_special_detail_entry_gallery)
    private TextView go;

    private long service_id;

    private long painter_id;

    private String content;

    private PainterServicePresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_service_details, container, false);
           ViewUtils.inject(this, view);
           service_id = getArguments().getLong("service_id", 0);
           painter_id = getArguments().getLong("painter_id", 0);
           content = getArguments().getString("content");
           presenter = new PainterServicePresenter(this);
           presenter.getHotServices(service_id);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        if( content!=null)
           webView.loadUrl(content);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pIntent = new Intent(getContext(),PainterActivity.class);
                pIntent.putExtra("painter_id",painter_id);
                startActivity(pIntent);
            }
        });
           return view;
    }

    public static ServiceDetailsFragment newInstance(long service_id,long painter_id,String content) {
        ServiceDetailsFragment pageFragment = new ServiceDetailsFragment();
        Bundle args = new Bundle();
        args.putLong("service_id",service_id);
        args.putLong("painter_id",painter_id);
        args.putString("content", content);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    private HotServiceGridViewAdapter adapter;

    @Override
    public void setServices(List<PainterService> services) {
        adapter = new HotServiceGridViewAdapter(getContext(),services);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ServiceDetailsActivity.class);
                intent.putExtra("service_id",adapter.getItem(position).getService_id());
                startActivity(intent);
            }
        });
    }
}
