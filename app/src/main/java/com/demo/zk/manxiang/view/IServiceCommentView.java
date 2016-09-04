package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.ServiceDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface IServiceCommentView extends IBaseView {
    void setServiceComment(List<ServiceDetail.Comment> data);
}
