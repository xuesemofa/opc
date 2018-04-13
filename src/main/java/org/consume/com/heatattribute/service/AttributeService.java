package org.consume.com.heatattribute.service;

import com.github.pagehelper.Page;
import org.consume.com.heatattribute.model.AttributeModel;

import java.util.List;

public interface AttributeService {
    /**
     * add
     *
     * @param model HeatModel
     * @return int
     */
    int add(AttributeModel model);

    /**
     * del
     *
     * @param id String
     * @return int
     */
    int del(String id);

    /**
     * update
     *
     * @param model HeatModel
     * @return int
     */

    int update(AttributeModel model);

    /**
     * findAllPage
     *
     * @param pageNow  int
     * @param pageSize int
     * @return Page<HeatModel>
     */
    Page<AttributeModel> findAllPage(int pageNow, int pageSize);

    List<AttributeModel> findAll();

    /**
     * getByNames
     *
     * @param names String
     * @return HeatModel
     */
    AttributeModel getByNames(String names);

    AttributeModel getById(String id);

    /**
     * 更改选择状态
     *
     * @param id
     * @param choice
     * @return
     */
    int choice(String id, boolean choice);

    List<AttributeModel> findByJzid(String jzid);

    List<AttributeModel> findBS();

    List<AttributeModel> findDB();
}
