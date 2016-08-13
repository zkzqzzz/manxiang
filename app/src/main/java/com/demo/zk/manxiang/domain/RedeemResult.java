package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/2.
 */
public class RedeemResult extends BaseDomain{

    private int status;

    private Service service;

    private ServiceParam service_param;

    public class Service {

        private String img;

        private String name;

        private float price;

        private long service_id;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public long getService_id() {
            return service_id;
        }

        public void setService_id(long service_id) {
            this.service_id = service_id;
        }

    }

    public class ServiceParam {

        private long param_id;

        private int paint_type;

        private String postage;

        private String price;

        private String param_content;

        public long getParam_id() {
            return param_id;
        }

        public void setParam_id(long param_id) {
            this.param_id = param_id;
        }

        public int getPaint_type() {
            return paint_type;
        }

        public void setPaint_type(int paint_type) {
            this.paint_type = paint_type;
        }

        public String getPostage() {
            return postage;
        }

        public void setPostage(String postage) {
            this.postage = postage;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getParam_content() {
            return param_content;
        }

        public void setParam_content(String param_content) {
            this.param_content = param_content;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceParam getService_param() {
        return service_param;
    }

    public void setService_param(ServiceParam service_param) {
        this.service_param = service_param;
    }
}
