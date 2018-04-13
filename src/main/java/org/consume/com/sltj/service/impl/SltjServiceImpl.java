package org.consume.com.sltj.service.impl;

import org.consume.com.sltj.mapper.SltjMapper;
import org.consume.com.sltj.model.SltjModel;
import org.consume.com.sltj.service.SltjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SltjServiceImpl implements SltjService {

    @Autowired
    private SltjMapper mapper;

    @Override
    public int add(Map<String, List<SltjModel>> map) {
        return mapper.add(map);
    }

    @Override
    public List<SltjModel> get(String id, String lx) {
        return mapper.get(id, lx);
    }
}
