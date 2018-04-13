package org.consume.com.crew.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.consume.com.crew.mapper.CrewMapper;
import org.consume.com.crew.model.CrewModel;
import org.consume.com.crew.service.CrewService;
import org.consume.com.util.uuidUtil.GetUuid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CrewServiceImpl implements CrewService {

    @Resource
    private CrewMapper mapper;

    @Override
    public int add(CrewModel model) {
        model.setUuid(GetUuid.getUUID());
        return mapper.add(model);
    }

    @Override
    public int del(String id) {
        return mapper.del(id);
    }

    @Override
    public int update(CrewModel model) {
        return mapper.update(model);
    }

    @Override
    public Page<CrewModel> findAllPage(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        return mapper.findAllPage();
    }

    @Override
    public List<CrewModel> findAll() {
        return mapper.findAll();
    }

    @Override
    public CrewModel getByNames(String names) {
        return mapper.getByNames(names);
    }

    @Override
    public CrewModel getById(String id) {
        return mapper.getById(id);
    }
}
