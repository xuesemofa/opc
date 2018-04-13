package org.consume.com.sltj.model;

/**
 * @table sltj_table
 */
public class SltjModel {
    private String uuid;
    //    累计量
    private String v;
    private long dates;
    private String zdid;
    //    1:水 2：电3:补水瞬时流量
    private String lx;
    //电单耗
    private double ddh;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public long getDates() {
        return dates;
    }

    public void setDates(long dates) {
        this.dates = dates;
    }

    public String getZdid() {
        return zdid;
    }

    public void setZdid(String zdid) {
        this.zdid = zdid;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public double getDdh() {
        return ddh;
    }

    public void setDdh(double ddh) {
        this.ddh = ddh;
    }

    public SltjModel() {
        super();
    }

    public SltjModel(String uuid, String v, long dates, String zdid, String lx, double ddh) {
        this.uuid = uuid;
        this.v = v;
        this.dates = dates;
        this.zdid = zdid;
        this.lx = lx;
        this.ddh = ddh;
    }

}
