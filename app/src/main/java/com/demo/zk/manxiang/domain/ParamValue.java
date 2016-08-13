package com.demo.zk.manxiang.domain;

/**
 * Created by houg on 2016/5/3.
 */
public class ParamValue extends BaseDomain{

    private String name;

    private String param_name;

    private String checked;

    private String unchecked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getUnchecked() {
        return unchecked;
    }

    public void setUnchecked(String unchecked) {
        this.unchecked = unchecked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParamValue that = (ParamValue) o;

        if (param_name != null ? !param_name.equals(that.param_name) : that.param_name != null)
            return false;
        if (checked != null ? !checked.equals(that.checked) : that.checked != null) return false;
        return !(unchecked != null ? !unchecked.equals(that.unchecked) : that.unchecked != null);

    }

    @Override
    public int hashCode() {
        int result = param_name != null ? param_name.hashCode() : 0;
        result = 31 * result + (checked != null ? checked.hashCode() : 0);
        result = 31 * result + (unchecked != null ? unchecked.hashCode() : 0);
        return result;
    }
}
