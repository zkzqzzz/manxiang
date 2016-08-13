package com.demo.zk.manxiang.view;


import com.demo.zk.manxiang.base.IBaseView;
import com.demo.zk.manxiang.domain.User;

/**
 * Created by HG on 2015/10/22.
 */
public interface IUserLoginView extends IBaseView {

    public void loginSuccess(User user);

}
