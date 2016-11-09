package com.dhao.dhframe;

/**
 * Created by DongHao on 2016/11/9.
 * Description:城市实体类
 */

public class CityBean {
    private String city;
    private String tag;

    public CityBean(String city, String tag) {
        this.city = city;
        this.tag = tag;
    }

    public CityBean() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
