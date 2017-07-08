package com.adamzfc.domain.repository;

import com.adamzfc.domain.model.Menu;
import com.adamzfc.infrastructure.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by adamzfc on 2017/7/7.
 */
@Mapper
public interface MenuRepository extends MyMapper<Menu> {
    @Update("UPDATE menu SET disabled = #{disable} WHERE id=#{id}")
    void switchStatus(@Param("id")String id, @Param("disable")Integer disable);

    @Select("SELECT * FROM menu where id = #{id}")
    Menu get(String id);

    @Delete("DELETE FROM menu WHERE id = #{id}")
    void remove(String id);

    @Select("SELECT * FROM menu")
    List<Menu> list();

    @Select("SELECT m.* FROM menu m" +
            " JOIN role_menu rm ON m.id = rm.menu_id" +
            " JOIN user_role ur ON rm.role_id = ur.role_id" +
            " WHERE m.disabled = 0 AND ur.uid = #{userId}")
    List<Menu> getNavMenus(String userId);
}
