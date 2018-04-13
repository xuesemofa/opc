package org.consume.com.heat.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.consume.com.heat.model.HeatModel;

import java.util.List;

/**
 * @name 换热站站点维护
 */
public interface HeatMapper {
    /**
     * add
     *
     * @param model HeatModel
     * @return int
     */
    @Insert({
            "insert into heat_table set uuid = #{model.uuid},names = #{model.names},parents=#{model.parents}"
    })
    int add(@Param("model") HeatModel model);

    /**
     * del
     *
     * @param id String
     * @return int
     */
    @Delete({
            "delete from heat_table where uuid = #{id}"
    })
    int del(@Param("id") String id);

    /**
     * update
     *
     * @param model HeatModel
     * @return int
     */
    @Update({
            "update heat_table set names = #{model.names},parents=#{model.parents} where uuid = #{model.uuid}"
    })
    int update(@Param("model") HeatModel model);

    /**
     * findAllPage
     *
     * @return Page<HeatModel>
     */
    @Select({
            "select h.uuid,h.`names`, " +
                    " case h.parents when '0' then '总部' else s.`names` end as parents  " +
                    " from heat_table h left join structure_table s on s.uuid = h.parents " +
                    " ORDER BY h.`names`"
    })
    Page<HeatModel> findAllPage();

    @Select({
            "select * from heat_table order by names"
    })
    List<HeatModel> findAll();

    @Select({
            "select * from heat_table where names = #{names}"
    })
    HeatModel getByNames(@Param("names") String names);

    @Select({
            "select * from heat_table where uuid = #{id}"
    })
    HeatModel getById(@Param("id") String id);

    @Select({
            "select * from heat_table h where h.parents = '8dc9315a8e4b43a58367ffe23c05458f' ORDER BY h.`names`"
    })
    List<HeatModel> findById(@Param("id") String parentId);
}
