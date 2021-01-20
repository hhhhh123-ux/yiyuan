package com.gzq.yiyuan.utils;

import com.google.common.collect.Lists;
import com.gzq.yiyuan.dao.UserDao;
import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.entiy.session.CurrentUser;
import com.gzq.yiyuan.service.UserService;
import io.swagger.models.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gaozhiqiang
 */
@Slf4j
public class CurrentUserUtils {

    /**
     * 获取当前登录用户（从session、header、token中获取）
     * @param
     * @return          返回用户封装
     */
    public static CurrentUser getCurrentUser() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          CurrentUser currentUser = new CurrentUser();
//        currentUser.setUserId(String.valueOf(user.getId()));
//        currentUser.setUserName(user.getUsername());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return currentUser;
    }
    public static Authentication getCurrentUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
    /**
     * 获取当前用户
     * @return
     */
    public static Object getCurrentPrincipal(){
        return getCurrentUserAuthentication().getPrincipal();
    }
}
