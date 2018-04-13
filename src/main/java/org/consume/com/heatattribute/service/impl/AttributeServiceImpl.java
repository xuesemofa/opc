package org.consume.com.heatattribute.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.consume.com.heatattribute.mapper.AttributeMapper;
import org.consume.com.heatattribute.model.AttributeModel;
import org.consume.com.heatattribute.service.AttributeService;
import org.consume.com.util.uuidUtil.GetUuid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AttributeServiceImpl implements AttributeService {

    @Resource
    private AttributeMapper mapper;

    @Override
    public int add(AttributeModel model) {
        model.setUuid(GetUuid.getUUID());
        return mapper.add(model);
    }

    @Override
    public int del(String id) {
        return mapper.del(id);
    }

    @Override
    public int update(AttributeModel model) {
        return mapper.update(model);
    }

    @Override
    public Page<AttributeModel> findAllPage(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        return mapper.findAllPage();
    }

    @Override
    public List<AttributeModel> findAll() {
        return mapper.findAll();
    }

    @Override
    public AttributeModel getByNames(String names) {
        return mapper.getByNames(names);
    }

    @Override
    public AttributeModel getById(String id) {
        return mapper.getById(id);
    }

    @Override
    public int choice(String id, boolean choice) {
        return mapper.choice(id, choice);
    }

    @Override
    public List<AttributeModel> findByJzid(String jzid) {
        return mapper.findByJzid(jzid);
    }

    @Override
    public List<AttributeModel> findBS() {
        return mapper.findBS();
    }

    @Override
    public List<AttributeModel> findDB() {
        return mapper.findDB();
    }
}
