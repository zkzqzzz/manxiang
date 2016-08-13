package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by houg on 2016/5/1.
 */
public class NewServicePanel extends BaseDomain {

    private String date;

    private List<PainterService>  services;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PainterService> getServices() {
        return services;
    }

    public void setServices(List<PainterService> services) {
        this.services = services;
    }
}
