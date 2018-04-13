package org.consume.com.opc.service;

import org.consume.com.opc.model.DatasModel;

import java.util.List;
import java.util.Map;

public interface OPCService {
    int save(Map<String, List<DatasModel>> map);
}
