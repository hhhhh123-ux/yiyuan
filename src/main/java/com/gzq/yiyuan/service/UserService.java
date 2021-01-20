package com.gzq.yiyuan.service;

import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.entiy.token.Token;
import com.gzq.yiyuan.result.AjaxResult;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;

public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record) throws ParseException;

    User selectByPrimaryKey(Long id);

    User selectByMobilePassword(@Param("mobile") String mobile,@Param("password") String password);

    User selectByName(@Param("username") String username);

    AjaxResult<Token> login(@Param("mobile") String mobile, @Param("password") String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
