package org.consume.com.opc.service.impl;

import org.consume.com.opc.mapper.OPC2Mapper;
import org.consume.com.opc.model.Datas2Model;
import org.consume.com.opc.service.OPC2Service;
import org.consume.com.util.uuidUtil.GetUuid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OPC2ServiceImpl implements OPC2Service {

    @Resource
    private OPC2Mapper mapper;

    @Override
    public int add(Datas2Model model) {
        model.setUuid(GetUuid.getUUID());
        return mapper.add(model);
    }

    @Override
    public int save(Map<String, List<Datas2Model>> map) {
        return mapper.save(map);
    }

    @Override
    public List<Datas2Model> findList(String id) {
        return mapper.findList(id);
    }

    @Override
    public List<Datas2Model> getById(String id,long a,long b) {
        return mapper.getById(id,a,b);
    }
}
