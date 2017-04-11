package com.adamzfc.domain.repository;

import com.adamzfc.domain.model.Role;
import com.adamzfc.infrastructure.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by adamzfc on 4/8/17.
 */
@Mapper
public interface RoleRepository extends MyMapper<Role> {
    @Select("SELECT * FROM ROLE R JOIN USER_ROLE UR ON R.ID=UR.ROLE_ID WHERE UR.UID=#{userId}")
    List<Role> getRoles(@Param("userId") int userId);
}
