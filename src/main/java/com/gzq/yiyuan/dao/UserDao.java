package com.gzq.yiyuan.dao;

import com.gzq.yiyuan.entiy.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User selectByMobilePassword(@Param("mobile") String mobile, @Param("password") String password);

    User selectByName(@Param("name") String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}