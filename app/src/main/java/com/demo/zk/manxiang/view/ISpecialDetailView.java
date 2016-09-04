package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.domain.SpecialDetail;
import com.demo.zk.manxiang.domain.Status;

import java.util.List;

/**
 * Created by houg on 2016/4/18.
 */
public interface ISpecialDetailView extends IBaseView {

    public void setSpecialDetail(SpecialDetail specialDetail);

    public void setSpecialServices(List<PainterService> services);

    void setCollectionResult(Status data);
}
