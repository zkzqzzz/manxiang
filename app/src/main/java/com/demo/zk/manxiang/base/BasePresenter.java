package com.demo.zk.manxiang.base;

import com.google.gson.Gson;

/**
 * Created by HG on 2015/10/23.
 */
/*什么是MVP

 .View是指显示数据并且和用户交互的层。可以是一个Activity，一个Fragment，一个android.view.View或者是一个Dialog。

 .Model 是数据源层。比如数据库接口或者远程服务器的api。

 .Presenter是从Model中获取数据并提供给View的层，Presenter还负责处理后台任务。

 MVP是一个将后台任务和activities/views/fragment分离的方法，让它们独立于绝大多数跟生命周期相关的事件。

 这样应用就会变得更简单，整个应用的稳定性提高10倍以上，代码也变得更短，可维护性增强，程序员也不会过劳死了~~*/
public class BasePresenter {

    protected Gson gson = new Gson();

    public final static int STATUS_OK = 200;
}
