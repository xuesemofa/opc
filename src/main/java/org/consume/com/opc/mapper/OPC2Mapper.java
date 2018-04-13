package org.consume.com.opc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.consume.com.opc.mapper.sql.SQLS;
import org.consume.com.opc.model.Datas2Model;

import java.util.List;
import java.util.Map;

public interface OPC2Mapper {

    @Insert({
            "insert into datas_2_table set "
                    + " uuid = #{model.uuid},"
                    + " T11=#{model.T11},"
                    + " T12=#{model.T12},"
                    + " P11=#{model.P11},"
                    + " P12=#{model.P12},"
                    + " ins_hea=#{model.ins_hea},"
                    + " ins_flo=#{model.ins_flo},"
                    + " acc_hea=#{model.acc_hea},"
                    + " T21=#{model.T21},"
                    + " T22=#{model.T22},"
                    + " P21=#{model.P21},"
                    + " P22=#{model.P22},"
                    + " lev=#{model.lev},"
                    + " mot_bac=#{model.mot_bac},"
                    + " bf_bac1=#{model.bf_bac1},"
                    + " xf_bac1=#{model.xf_bac1},"
                    + " xI_bac1=#{model.xI_bac1},"
                    + " xf_bac2=#{model.xf_bac2},"
                    + " xI_bac2=#{model.xI_bac2},"
                    + " bl1=#{model.bl1},"
                    + " bl2=#{model.bl2},"
                    + " bl3=#{model.bl3},"
                    + " bl4=#{model.bl4},"
                    + " bl5=#{model.bl5},"
                    + " bl6=#{model.bl6},"
                    + " bl7=#{model.bl7},"
                    + " bl8=#{model.bl8},"
                    + " bl9=#{model.bl9},"
                    + " bl10=#{model.bl10}"
    })
    int add(@Param("model") Datas2Model model);

    //    此注解多个参数必须map类型
    @InsertProvider(type = SQLS.class, method = "inserts2")
    int save(Map<String, List<Datas2Model>> map);

    @Select({
            "SELECT"
                    + "      c.parents jzid,"
                    + "      d.T22,"
                    + "      d.T21,"
                    + "      d.T12,"
                    + "      d.T11,"
                    + "      d.P22,"
                    + "      d.P21,"
                    + "      d.P12,"
                    + "      d.P11,"
                    + "      d.mot_bac,"
                    + "      d.lev,"
                    + "      d.ins_hea,"
                    + "      d.ins_flo,"
                    + "      d.acc_hea,"
                    + "      d.xI_bac2,"
                    + "      d.xf_bac2,"
                    + "      d.xI_bac1,"
                    + "      d.xf_bac1,"
                    + "      d.bf_bac1,"
                    + "      d.dates"
                    + " FROM"
                    + "      datas_2_table d"
                    + " LEFT JOIN crew_table c ON c.uuid = d.jzid"
                    + " WHERE"
                    + "      c.uuid IN ("
                    + "           SELECT"
                    + "                c.uuid"
                    + "           FROM"
                    + "                crew_table c"
                    + "           WHERE"
                    + "                c.parents IN ("
                    + "                     SELECT"
                    + "                          uuid"
                    + "                     FROM"
                    + "                          heat_table"
                    + "                     WHERE"
                    + "                          parents = #{id}"
                    + "                )"
                    + "      )"
                    + " AND d.dates IN ("
                    + "      SELECT"
                    + "           MAX(d2.dates) dates"
                    + "      FROM"
                    + "           datas_2_table d2"
                    + " )"
                    + " ORDER BY"
                    + "      c.`names`"
    })
    List<Datas2Model> findList(@Param("id") String id);

    @Select({
            "SELECT" +
                    " * " +
                    " FROM " +
                    " datas_2_table d2 " +
                    " WHERE " +
                    " d2.dates = (select MAX(d.dates) dates from datas_2_table d where d.dates >= #{a} "
                    + " and d.dates <= #{b} and d.jzid = #{id}) AND d2.jzid =#{id}"
    })
    List<Datas2Model> getById(@Param("id") String id, @Param("a") long a, @Param("b") long b);

}
