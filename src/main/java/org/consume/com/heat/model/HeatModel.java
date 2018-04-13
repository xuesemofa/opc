package org.consume.com.heat.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @name 换热站维护
 * @table heat_table
 */
public class HeatModel implements Serializable {
    //    id
    private String uuid;
    //    换热站名称
    @NotBlank(message = "换热站名称不能为空")
    @Size(min = 1, max = 30, message = "换热站名称长度位1-30")
    private String names;

    private String parents;

    public HeatModel() {
        super();
    }

    public HeatModel(String uuid, String names, String parents) {
        this.uuid = uuid;
        this.names = names;
        this.parents = parents;
    }

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

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "HeatModel{" +
                "uuid='" + uuid + '\'' +
                ", names='" + names + '\'' +
                ", parents='" + parents + '\'' +
                '}';
    }
}
