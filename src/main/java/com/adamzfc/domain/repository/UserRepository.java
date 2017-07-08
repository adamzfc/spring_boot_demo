package com.adamzfc.domain.repository;

import com.adamzfc.domain.model.User;
import com.adamzfc.infrastructure.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by adamzfc on 4/8/17.
 */
@Mapper
public interface UserRepository extends MyMapper<User> {
    @Select("SELECT * FROM USER WHERE username = #{username}")
    User findByUserName(@Param("username") String username);

    @Insert("INSERT INTO USER (username, password, salt, email, createTime)" +
            "VALUES(#{username}, #{password}, #{salt}, #{email}, NOW())")
    void saveUser(User user);

    @Update("UPDATE user SET disabled = #{disable} WHERE id = #{id}")
    void switchStatus(@Param("id") String id, @Param("disable") int disable);

    @Select("SELECT * FROM user WHERE username <> 'root'")
    List<User> list();
}
