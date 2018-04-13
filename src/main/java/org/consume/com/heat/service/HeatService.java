package org.consume.com.heat.service;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.consume.com.heat.model.HeatModel;

import java.util.List;

public interface HeatService {
    /**
     * add
     *
     * @param model HeatModel
     * @return int
     */
    int add(HeatModel model);

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

    int update(HeatModel model);

    /**
     * findAllPage
     *
     * @param pageNow  int
     * @param pageSize int
     * @return Page<HeatModel>
     */
    Page<HeatModel> findAllPage(int pageNow, int pageSize);

    List<HeatModel> findAll();

    /**
     * getByNames
     *
     * @param names String
     * @return HeatModel
     */
    HeatModel getByNames(String names);

    HeatModel getById(String id);

    List<HeatModel> findById(String parentId);
}
