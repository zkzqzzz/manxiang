package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/5/2.
 */
public class ServiceDetail extends BaseDomain{

    private List<Comment> comments;

    private String coupon_name;

    private List<Images> imgs;

    private int is_collection;

    private int is_coupon;

    private int is_praise;

    private Painter painter;

    private Service service;

    private List<ServiceParam> service_param;

    public class Comment {

        private String add_time;

        private long comment_id;

        private String content;

        private String param_content;

        private float point;

        private long user_id;

        private String user_img;

        private String user_nickname;


        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public long getComment_id() {
            return comment_id;
        }

        public void setComment_id(long comment_id) {
            this.comment_id = comment_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getParam_content() {
            return param_content;
        }

        public void setParam_content(String param_content) {
            this.param_content = param_content;
        }

        public float getPoint() {
            return point;
        }

        public void setPoint(float point) {
            this.point = point;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getUser_img() {
            return user_img;
        }

        public void setUser_img(String user_img) {
            this.user_img = user_img;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }
    }

    public class Images {

        private String img;

        private long img_id;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public long getImg_id() {
            return img_id;
        }

        public void setImg_id(long img_id) {
            this.img_id = img_id;
        }
    }

    public class Painter {

        private String img;

        private String nickname;

        private long painter_id;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getPainter_id() {
            return painter_id;
        }

        public void setPainter_id(long painter_id) {
            this.painter_id = painter_id;
        }
    }

    public class Service {

        private long service_id;

        private String name;

        private String price;

        private int is_discount;

        private String discount_price;

        private String content;

        private String content_url;

        private String paint_time;

        private int sold_count;

        private int praise_count;

        public long getService_id() {
            return service_id;
        }

        public void setService_id(long service_id) {
            this.service_id = service_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getIs_discount() {
            return is_discount;
        }

        public void setIs_discount(int is_discount) {
            this.is_discount = is_discount;
        }

        public String getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(String discount_price) {
            this.discount_price = discount_price;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent_url() {
            return content_url;
        }

        public void setContent_url(String content_url) {
            this.content_url = content_url;
        }

        public String getPaint_time() {
            return paint_time;
        }

        public void setPaint_time(String paint_time) {
            this.paint_time = paint_time;
        }

        public int getSold_count() {
            return sold_count;
        }

        public void setSold_count(int sold_count) {
            this.sold_count = sold_count;
        }

        public int getPraise_count() {
            return praise_count;
        }

        public void setPraise_count(int praise_count) {
            this.praise_count = praise_count;
        }
    }

    public class ServiceParam {

        private int paint_type;

        private String paint_type_name;

        private List<Params> params;

        public class Params {

            private float discount_price;

            private int is_discount;

            private int is_seckill;

            private long param_id;

            private String param_name;

            private float postage;

            private float price;

            private float seckill_price;


            public float getDiscount_price() {
                return discount_price;
            }

            public void setDiscount_price(float discount_price) {
                this.discount_price = discount_price;
            }

            public int getIs_discount() {
                return is_discount;
            }

            public void setIs_discount(int is_discount) {
                this.is_discount = is_discount;
            }

            public int getIs_seckill() {
                return is_seckill;
            }

            public void setIs_seckill(int is_seckill) {
                this.is_seckill = is_seckill;
            }

            public long getParam_id() {
                return param_id;
            }

            public void setParam_id(long param_id) {
                this.param_id = param_id;
            }

            public String getParam_name() {
                return param_name;
            }

            public void setParam_name(String param_name) {
                this.param_name = param_name;
            }

            public float getPostage() {
                return postage;
            }

            public void setPostage(float postage) {
                this.postage = postage;
            }

            public float getPrice() {
                return price;
            }

            public void setPrice(float price) {
                this.price = price;
            }

            public float getSeckill_price() {
                return seckill_price;
            }

            public void setSeckill_price(float seckill_price) {
                this.seckill_price = seckill_price;
            }
        }

        public int getPaint_type() {
            return paint_type;
        }

        public void setPaint_type(int paint_type) {
            this.paint_type = paint_type;
        }

        public String getPaint_type_name() {
            return paint_type_name;
        }

        public void setPaint_type_name(String paint_type_name) {
            this.paint_type_name = paint_type_name;
        }

        public List<Params> getParams() {
            return params;
        }

        public void setParams(List<Params> params) {
            this.params = params;
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public List<Images> getImgs() {
        return imgs;
    }

    public void setImgs(List<Images> imgs) {
        this.imgs = imgs;
    }

    public int getIs_collection() {
        return is_collection;
    }

    public void setIs_collection(int is_collection) {
        this.is_collection = is_collection;
    }

    public int getIs_coupon() {
        return is_coupon;
    }

    public void setIs_coupon(int is_coupon) {
        this.is_coupon = is_coupon;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ServiceParam> getService_param() {
        return service_param;
    }

    public void setService_param(List<ServiceParam> service_param) {
        this.service_param = service_param;
    }
}
