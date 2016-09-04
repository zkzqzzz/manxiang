package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.Painter;

import java.util.List;

/**
 * Created by houg on 2015/10/27.
 */
public interface IPainterView extends IBaseView {

    public void setPainter(Painter painter);

    public void setPainters(List<Painter> painters);

}
