package org.consume.com.opc.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.consume.com.opc.mapper.sql.SQLS;
import org.consume.com.opc.model.DatasModel;

import java.util.List;
import java.util.Map;

public interface OPCMapper {
    //    此注解多个参数必须map类型
    @InsertProvider(type = SQLS.class, method = "inserts")
    int save(Map<String, List<DatasModel>> map);
}
