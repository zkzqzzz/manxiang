package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.domain.Status;

/**
 * Created by Administrator on 2016/5/2.
 */
public interface IServiceDetailView extends IBaseView {

    void setServiceDetail(ServiceDetail data);

    void setCollectionResult(Status data);

    void setPraiseResult(Status data);
}
