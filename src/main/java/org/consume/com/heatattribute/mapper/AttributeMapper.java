package org.consume.com.heatattribute.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.consume.com.heatattribute.model.AttributeModel;

import java.util.List;

/**
 * @name 换热站属性集合
 */
public interface AttributeMapper {
    /**
     * add
     *
     * @param model HeatModel
     * @return int
     */
    @Insert({
            "insert into heat_attribute_table set uuid = #{model.uuid},names = #{model.names}," +
                    "orders=#{model.orders},states=#{model.states},choice=#{model.choice},jzid=#{model.jzid},bs=#{model.bs}"
    })
    int add(@Param("model") AttributeModel model);

    /**
     * del
     *
     * @param id String
     * @return int
     */
    @Delete({
            "delete from heat_attribute_table where uuid = #{id}"
    })
    int del(@Param("id") String id);

    /**
     * update
     *
     * @param model HeatModel
     * @return int
     */
    @Update({
            "update heat_attribute_table set names = #{model.names} where uuid = #{model.uuid}"
    })
    int update(@Param("model") AttributeModel model);

    /**
     * findAllPage
     *
     * @return Page<HeatModel>
     */
    @Select({
            "select h.uuid,h.`names`,h.orders,h.choice,h.bs,c.`names` as jzid from heat_attribute_table h " +
                    " LEFT JOIN crew_table c on c.uuid = h.jzid order by jzid,bs"
    })
    Page<AttributeModel> findAllPage();

    @Select({
            "select * from heat_attribute_table order by names"
    })
    List<AttributeModel> findAll();

    @Select({
            "select * from heat_attribute_table where names = #{names}"
    })
    AttributeModel getByNames(@Param("names") String names);

    @Select({
            "select * from heat_attribute_table where uuid = #{id}"
    })
    AttributeModel getById(@Param("id") String id);

    @Update({
            "update heat_attribute_table set choice = #{choice} where uuid = #{id}"
    })
    int choice(@Param("id") String id, @Param("choice") boolean choice);

    /**
     * 根据机组id查询属性
     */
    @Select({
            "select * from heat_attribute_table where jzid = #{jzid}"
    })
    List<AttributeModel> findByJzid(@Param("jzid") String jzid);

    /**
     * 获取所有机组的所有属性
     */
    @Select({
            "SELECT * from heat_attribute_table"
    })
    List<AttributeModel> findBS();

    /**
     * 获取对比项
     */
    @Select({
            "SELECT * from heat_attribute_table h where h.choice = 1"
    })
    List<AttributeModel> findDB();
}
