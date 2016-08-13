package com.demo.zk.manxiang.view;



import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.Banner;

import java.util.List;

/**
 * Created by houg on 2015/10/27.
 */
public interface IBannerView extends IBaseView {

    public void setBanners(List<Banner> banners);

}
