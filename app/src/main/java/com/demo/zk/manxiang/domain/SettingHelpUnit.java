package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/4/11.
 */
public class SettingHelpUnit extends BaseDomain{

    private String content;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
