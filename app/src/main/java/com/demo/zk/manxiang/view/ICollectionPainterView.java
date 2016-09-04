package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.CollectionPainter;
import com.demo.zk.manxiang.domain.Status;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface ICollectionPainterView extends IBaseView {

    void setCollectionPainterList(List<CollectionPainter> data);

    void setPainterCollectionResult(Status data);

    void setPainterCollectionSearch(List<CollectionPainter> data);

    void setPainterCancelCollection(Status data);
}
