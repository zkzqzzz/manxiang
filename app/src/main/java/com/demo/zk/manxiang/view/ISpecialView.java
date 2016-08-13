package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.CollectionSpecial;
import com.demo.zk.manxiang.domain.Special;
import com.demo.zk.manxiang.domain.Status;

import java.util.List;

/**
 * Created by houg on 2016/4/18.
 */
public interface ISpecialView extends IBaseView {

    void setSpecials(List<Special> specials);

    void setSpecialViewCollectionSearch(List<CollectionSpecial> data);

    void setSpecialCollectionList(List<CollectionSpecial> data);

    void setSpecialCollectionResult(Status data);

    void setSpecialCancelCollection(Status data);
}
