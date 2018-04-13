package org.consume.com.heatattribute.model;

import java.io.Serializable;

/**
 * @name 换热站属性集合model
 * @table heat_attribute_table
 */
public class AttributeModel implements Serializable {
    //    id
    private String uuid;
    //    属性名称
    private String names;
    //    顺序
    private Integer orders;
    //    状态
    private String states;
    //    是否选择
    private boolean choice;
    //    所属机组
    private String jzid;
    //    服务器标识
    private String bs;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public String getJzid() {
        return jzid;
    }

    public void setJzid(String jzid) {
        this.jzid = jzid;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public AttributeModel() {
        super();
    }

    public AttributeModel(String uuid, String names, Integer orders, String states, boolean choice, String jzid, String bs) {
        this.uuid = uuid;
        this.names = names;
        this.orders = orders;
        this.states = states;
        this.choice = choice;
        this.jzid = jzid;
        this.bs = bs;
    }
}
