package org.consume.com.crew.service;

import com.github.pagehelper.Page;
import org.consume.com.crew.model.CrewModel;

import java.util.List;

public interface CrewService {
    /**
     * add
     *
     * @param model HeatModel
     * @return int
     */
    int add(CrewModel model);

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

    int update(CrewModel model);

    /**
     * findAllPage
     *
     * @param pageNow  int
     * @param pageSize int
     * @return Page<HeatModel>
     */
    Page<CrewModel> findAllPage(int pageNow, int pageSize);

    List<CrewModel> findAll();

    /**
     * getByNames
     *
     * @param names String
     * @return HeatModel
     */
    CrewModel getByNames(String names);

    CrewModel getById(String id);
}
