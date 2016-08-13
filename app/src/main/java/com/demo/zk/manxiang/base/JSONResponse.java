package com.demo.zk.manxiang.base;

import java.io.Serializable;

/**
 * Created by HG on 2015/10/22.
 */
public class JSONResponse<T> implements Serializable {


    public int code = 1;

    public String desc;

    public T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
