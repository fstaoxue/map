package com.taoge.business.parsexls.bean;

import com.taoge.business.main.bean.Excel;

/**
 * @author 1001234
 * @date 2019/05/22
 */
public class LocInfo {
    private String infotype;

    @Excel(title = "纬度")
    private double lat;
    @Excel(title = "经度")
    private double lng;
    private String sno;
    @Excel(title="捕获时间")
    private long cp;
    private String info;
    private String evt;
    private String relatenum;
    private String relatehomeac;
    private String engine_type;
    private String keyword;

    public String getInfotype() {
        return infotype;
    }

    public void setInfotype(String infotype) {
        this.infotype = infotype;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public long getCp() {
        return cp;
    }

    public void setCp(long cp) {
        this.cp = cp;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEvt() {
        return evt;
    }

    public void setEvt(String evt) {
        this.evt = evt;
    }

    public String getRelatenum() {
        return relatenum;
    }

    public void setRelatenum(String relatenum) {
        this.relatenum = relatenum;
    }

    public String getRelatehomeac() {
        return relatehomeac;
    }

    public void setRelatehomeac(String relatehomeac) {
        this.relatehomeac = relatehomeac;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "LocInfo{" +
                "infotype='" + infotype + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", sno='" + sno + '\'' +
                ", cp=" + cp +
                ", info='" + info + '\'' +
                ", evt='" + evt + '\'' +
                ", relatenum='" + relatenum + '\'' +
                ", relatehomeac='" + relatehomeac + '\'' +
                ", engine_type='" + engine_type + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
