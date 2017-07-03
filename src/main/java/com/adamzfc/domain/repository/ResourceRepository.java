package com.adamzfc.domain.repository;

import com.adamzfc.domain.model.Resource;
import com.adamzfc.infrastructure.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by adamzfc on 4/8/17.
 */
@Mapper
public interface ResourceRepository extends MyMapper<Resource> {
//    void add(Resource resource);
//
//    void update(Resource resource);
//
//    Resource get(String code);
//
//    List<Resource> list();
//
//    void remove(String code);
//
//    void switchStatus(String code, boolean disabled);
//
//    List<Resource> listByRole(String roleId);
//
    @Select("SELECT * FROM RESOURCE WHERE disable = 0")
    List<Resource> getEnableResources();

}
