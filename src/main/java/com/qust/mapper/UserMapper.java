package com.qust.mapper;

import com.qust.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Tan Weichao on 2017/4/13.
 */
public interface UserMapper {
    @Select("select * from users where userId = #{userId}")
    User findUserByUserid(@Param("userId") String userId);

    @Insert("insert into users (userId,pwd) values (#{userId},#{pwd})")
    boolean insertUsers (@Param("userId") String userId,@Param("pwd") String pwd);

    @Select("select * from user")
    List<User> getUsers();
}

