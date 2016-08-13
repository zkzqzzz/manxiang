package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class RegionDomain extends BaseDomain{

    private List<City> child;

    private String name;

    private long parent_id;

    private long region_id;

    private int type;

    public class City {

        private List<Area> child;

        private String name;

        private long parent_id;

        private long region_id;

        private int type;

        public class Area{

            private String name;

            private long parent_id;

            private long region_id;

            private int type;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getParent_id() {
                return parent_id;
            }

            public void setParent_id(long parent_id) {
                this.parent_id = parent_id;
            }

            public long getRegion_id() {
                return region_id;
            }

            public void setRegion_id(long region_id) {
                this.region_id = region_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public List<Area> getChild() {
            return child;
        }

        public void setChild(List<Area> child) {
            this.child = child;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getParent_id() {
            return parent_id;
        }

        public void setParent_id(long parent_id) {
            this.parent_id = parent_id;
        }

        public long getRegion_id() {
            return region_id;
        }

        public void setRegion_id(long region_id) {
            this.region_id = region_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public List<City> getChild() {
        return child;
    }

    public void setChild(List<City> child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(long region_id) {
        this.region_id = region_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
