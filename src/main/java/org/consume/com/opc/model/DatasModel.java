package org.consume.com.opc.model;

/**
 * opcclient 返回数据
 *
 * @table opc_datas_table
 *
 */
public class DatasModel {
    private String uuid;
    private String k;
    private String v;
    private Long dates;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Long getDates() {
        return dates;
    }

    public void setDates(Long dates) {
        this.dates = dates;
    }

    public DatasModel() {
        super();
    }

    public DatasModel(String uuid, String k, String v, Long dates) {
        this.uuid = uuid;
        this.k = k;
        this.v = v;
        this.dates = dates;
    }
}
