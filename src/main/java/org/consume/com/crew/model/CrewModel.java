package org.consume.com.crew.model;

/**
 * @name 机组维护
 * @table crew_table
 */
public class CrewModel {
    //    id
    private String uuid;
    //    机组名称
    private String names;
    //    顺序
    private Integer orders;

    //    父id
    private String parents;

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

    public CrewModel() {
        super();
    }

    public CrewModel(String uuid, String names, Integer orders, String parents) {
        this.uuid = uuid;
        this.names = names;
        this.orders = orders;
        this.parents = parents;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "CrewModel{" +
                "uuid='" + uuid + '\'' +
                ", names='" + names + '\'' +
                ", orders=" + orders +
                ", parents='" + parents + '\'' +
                '}';
    }
}
