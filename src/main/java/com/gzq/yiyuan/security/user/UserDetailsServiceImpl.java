package com.gzq.yiyuan.security.user;

import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author SongYC
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        //根据用户名查询用户
        User user = userService.selectByName(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        return (UserDetails) user;
    }
}
