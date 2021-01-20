package com.gzq.yiyuan.controller;

import com.gzq.yiyuan.entiy.Role;
import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.entiy.token.Token;
import com.gzq.yiyuan.result.AjaxResult;
import com.gzq.yiyuan.service.RoleService;
import com.gzq.yiyuan.service.UserRoleService;
import com.gzq.yiyuan.service.UserService;
import com.gzq.yiyuan.service.token.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SongYC
 */
@Api(value = "登录功能")
@Slf4j
@RestController
@RequestMapping("/user/form")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRoleService userRoleService;
    /****
     *登录功能
     *
     *
     */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public AjaxResult login(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
       AjaxResult<Token> tokenAjaxResult= userService.login(mobile, password);
       Token token=tokenAjaxResult.getData();
        User user = userService.selectByMobilePassword(mobile, password);
        List<Role> role=roleService.selectByPrimaryKey(user.getId());
       token.setRoles(role);
        return AjaxResult.success(tokenAjaxResult);
    }


    @PostMapping(value = "/roleUser")
    @ResponseBody
    public AjaxResult RoleUser(@RequestParam Long userId, @RequestBody List<String> roleIds){
        userRoleService.insert(userId,roleIds);
        return AjaxResult.success(1);
    }



}
