package com.demo.zk.manxiang.view;



import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.ImageAddress;
import com.demo.zk.manxiang.domain.PlaceOrder;
import com.demo.zk.manxiang.domain.PreparePlaceOrder;
import com.demo.zk.manxiang.domain.UserAddress;

import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public interface IPreparePlaceOrderView extends IBaseView {

    void setPreparePlaceOrder(PreparePlaceOrder data);

    void setPlaceOrder(PlaceOrder data);

    void setUploadImage(ImageAddress data);

    void setDefaultAddress(List<UserAddress> data);

    void setAddress(UserAddress data);
}
