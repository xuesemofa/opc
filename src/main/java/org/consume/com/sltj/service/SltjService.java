package org.consume.com.sltj.service;

import org.consume.com.sltj.model.SltjModel;

import java.util.List;
import java.util.Map;

public interface SltjService {
    int add(Map<String, List<SltjModel>> map);

    List<SltjModel> get(String id,String lx);
}
