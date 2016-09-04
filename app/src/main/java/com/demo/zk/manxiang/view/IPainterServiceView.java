package com.demo.zk.manxiang.view;



import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.PainterService;

import java.util.List;

/**
 * Created by houg on 2015/10/27.
 */
public interface IPainterServiceView extends IBaseView {

    public void setServices(List<PainterService> services);

}
