package org.consume.com.heat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.consume.com.heat.mapper.HeatMapper;
import org.consume.com.heat.model.HeatModel;
import org.consume.com.heat.service.HeatService;
import org.consume.com.util.uuidUtil.GetUuid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class HeatServiceImpl implements HeatService {

    @Resource
    private HeatMapper mapper;

    @Override
    public int add(HeatModel model) {
        model.setUuid(GetUuid.getUUID());
        return mapper.add(model);
    }

    @Override
    public int del(String id) {
        return mapper.del(id);
    }

    @Override
    public int update(HeatModel model) {
        return mapper.update(model);
    }

    @Override
    public Page<HeatModel> findAllPage(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        return mapper.findAllPage();
    }

    @Override
    public List<HeatModel> findAll() {
        return mapper.findAll();
    }

    @Override
    public HeatModel getByNames(String names) {
        return mapper.getByNames(names);
    }

    @Override
    public HeatModel getById(String id) {
        return mapper.getById(id);
    }

    @Override
    public List<HeatModel> findById(String parentId) {
        return mapper.findById(parentId);
    }
}
