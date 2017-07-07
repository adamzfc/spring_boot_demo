package com.adamzfc.domain.repository;

import com.adamzfc.application.MenuService;
import com.adamzfc.domain.model.Menu;
import com.adamzfc.infrastructure.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by adamzfc on 2017/7/7.
 */
@Mapper
public interface MenuRepository {

//    @Insert("INSERT menu (id, label, path, `level`, `order`, `url`," +
//            " `type`, `style`, `disable`)" +
//            " VALUES(#{menu.getId()}, #{menu.getLabel()}, #{menu.getPath}," +
//            " #{menu.getLevel()}, #{menu.getOrder()}, #{menu.getUrl()}, " +
//            " #{menu.getType()}, #{menu.getStyle()}, #{menu.isDisabled()})")
@Insert("INSERT menu (id, label, path, `level`, `order`, `url`," +
        " `type`, `style`, `disable`)" +
        " VALUES(#{menu})")
    void add(Menu menu);

    @Select("SELECT * FROM menu where id = #{id}")
    Menu get(String id);

    @Select("SELECT * FROM menu")
    List<Menu> list();

    @Select("SELECT m.* FROM menu m" +
            " JOIN role_menu rm ON m.id = rm.menu_id" +
            " JOIN user_role ur ON rm.role_id = ur.role_id" +
            " WHERE m.disabled = 0 AND ur.uid = #{userId}")
    List<Menu> getNavMenus(String userId);
}
