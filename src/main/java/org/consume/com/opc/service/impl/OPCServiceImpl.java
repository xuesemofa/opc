package org.consume.com.opc.service.impl;

import org.consume.com.opc.mapper.OPCMapper;
import org.consume.com.opc.model.DatasModel;
import org.consume.com.opc.service.OPCService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OPCServiceImpl implements OPCService {

    @Resource
    private OPCMapper mapper;

    @Override
    public int save(Map<String, List<DatasModel>> map) {
        if (map == null || map.size() < 1)
            return 0;
        return mapper.save(map);
    }
}
