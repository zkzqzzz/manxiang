package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.Banner;
import com.demo.zk.manxiang.domain.Category;

import java.util.List;

/**
 * Created by houg on 2015/10/27.
 */
public interface IBrowseView extends IBaseView {

    public void setCategories(List<Category> cats);

    public void setBanners(int cat_id, List<Banner> banners);

}
