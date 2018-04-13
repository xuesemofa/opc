package org.consume.com.sltj.mapper.sql;

import org.consume.com.sltj.model.SltjModel;
import org.consume.com.util.uuidUtil.GetUuid;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class SQLS {
    public String inserts(Map<String, List<SltjModel>> map) {
        StringJoiner sql = new StringJoiner("");
        map.forEach((k, v) -> {
            List<SltjModel> list = v;
            list.forEach((j) -> {
                String q = "insert into sltj_table values "
                        + " ('" + GetUuid.getUUID() + "','"
                        + j.getV() + "'," + j.getDates() + ",'"
                        + j.getZdid() + "','" + j.getLx() + "')";
                if (list.size() > 1 || map.size() > 0)
                    q += ";";
                sql.add(q);
            });
        });
        System.out.println(sql.toString());
        return sql.toString();
    }
}
