package com.demo.zk.manxiang.domain;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/4/6.
 */
public class SpecialSelectedGoodsUnit extends BaseDomain{

    private Bitmap image;
    private String content;
    private float discount;
    private float original;
    private int something;

    public SpecialSelectedGoodsUnit() {
        super();
    }

    public SpecialSelectedGoodsUnit(Bitmap image, String content, int discount, int original, int something) {
        this.image = image;
        this.content = content;
        this.discount = discount;
        this.original = original;
        this.something = something;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getOriginal() {
        return original;
    }

    public void setOriginal(float original) {
        this.original = original;
    }

    public int getSomething() {
        return something;
    }

    public void setSomething(int something) {
        this.something = something;
    }

}
