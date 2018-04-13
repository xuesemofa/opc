package org.consume.com.sltj.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.consume.com.sltj.mapper.sql.SQLS;
import org.consume.com.sltj.model.SltjModel;

import java.util.List;
import java.util.Map;

public interface SltjMapper {
    @InsertProvider(type = SQLS.class, method = "inserts")
    int add(Map<String, List<SltjModel>> map);

    @Select({
            "select * from sltj_table s1 where s1.dates in (" +
                    "select MAX(s.dates) from sltj_table s where s.zdid = #{id} and s.lx=#{lx}) and s1.zdid = #{id} and s1.lx=#{lx}"
    })
    List<SltjModel> get(@Param("id") String id, @Param("lx") String lx);

}
