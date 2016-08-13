package com.demo.zk.manxiang.domain;

/**
 * Created by WG on 2016/3/26.
 */
public class FunctionUnit extends BaseDomain{

    private String textContent;
    private int imageResource;

    public FunctionUnit(String textContent, int imageResource) {
        this.textContent = textContent;
        this.imageResource = imageResource;
    }

    public String getTextContent() {
        return textContent;
    }

    public int getImageResource() {
        return imageResource;
    }

}
