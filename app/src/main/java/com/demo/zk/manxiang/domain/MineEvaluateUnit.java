package com.demo.zk.manxiang.domain;

import android.graphics.Bitmap;

/**
 *
 * Created by WG on 2016/3/27.
 */
public class MineEvaluateUnit extends BaseDomain{
    private Bitmap icon;
    private String title;
    private String method;
    private String size;
    private int level;
    private long time;
    private String content;

    public MineEvaluateUnit() {
        super();
    }

    public MineEvaluateUnit(Bitmap icon, String title, String method, String size, int level, int time, String content) {
        this.icon = icon;
        this.title = title;
        this.method = method;
        this.size = size;
        this.level = level;
        this.time = time;
        this.content = content;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
