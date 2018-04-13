package org.consume.com.opc.mapper.sql;

import org.consume.com.opc.model.Datas2Model;
import org.consume.com.opc.model.DatasModel;
import org.consume.com.util.uuidUtil.GetUuid;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class SQLS {
    public String inserts(Map<String, List<DatasModel>> map) {
        StringJoiner sql = new StringJoiner("");
        long time = new Date().getTime();
        map.forEach((k, v) -> {
            List<DatasModel> list = v;
            list.forEach((j) -> {
                String q = "insert into opc_datas_table values "
                        + " ('" + GetUuid.getUUID() + "','"
                        + j.getK() + "','" + j.getV() + "',"
                        + time + ")";
                if (list.size() > 1 || map.size() > 0)
                    q += ";";
                sql.add(q);
            });
        });
        System.out.println(sql.toString());
        return sql.toString();
    }

    public String inserts2(Map<String, List<Datas2Model>> map) {

        StringJoiner sql = new StringJoiner("");
        long time = new Date().getTime();
        map.forEach((k, v) -> {
            v.forEach((j) -> {
                String s = "insert into datas_2_table set "
                        + " uuid = '" + GetUuid.getUUID() + "',"
                        + " jzid = '" + j.getJzid() + "',"
                        + " dates = " + j.getDates() + ","
                        + " T11='" + j.getT11() + "',"
                        + " T12='" + j.getT12() + "',"
                        + " P11='" + j.getP11() + "',"
                        + " P12='" + j.getP12() + "',"
                        + " ins_hea='" + j.getIns_hea() + "',"
                        + " ins_flo='" + j.getIns_flo() + "',"
                        + " acc_hea='" + j.getAcc_hea() + "',"
                        + " T21='" + j.getT21() + "',"
                        + " T22='" + j.getT22() + "',"
                        + " P21='" + j.getP21() + "',"
                        + " P22='" + j.getP22() + "',"
                        + " lev='" + j.getLev() + "',"
                        + " mot_bac='" + j.getMot_bac() + "',"
                        + " bf_bac1='" + j.getBf_bac1() + "',"
                        + " xf_bac1='" + j.getXf_bac1() + "',"
                        + " xI_bac1='" + j.getxI_bac1() + "',"
                        + " xf_bac2='" + j.getXf_bac2() + "',"
                        + " xI_bac2='" + j.getxI_bac2() + "',"
                        + " bl1='" + j.getBl1() + "',"
                        + " bl2='" + j.getBl2() + "',"
                        + " bl3='" + j.getBl3() + "',"
                        + " bl4='" + j.getBl4() + "',"
                        + " bl5='" + j.getBl5() + "',"
                        + " bl6='" + j.getBl6() + "',"
                        + " bl7='" + j.getBl7() + "',"
                        + " bl8='" + j.getBl8() + "',"
                        + " bl9='" + j.getBl9() + "',"
                        + " bl10='" + j.getBl10() + "'";
                if (v.size() > 1)
                    s += ";";
                sql.add(s);
            });
        });
        System.out.println(sql.toString());
        return sql.toString();
    }
}
