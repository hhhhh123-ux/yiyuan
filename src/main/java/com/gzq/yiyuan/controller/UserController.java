package com.gzq.yiyuan.controller;

import com.gzq.yiyuan.result.AjaxResult;
import com.gzq.yiyuan.service.UserService;
import com.gzq.yiyuan.service.token.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    TokenService tokenService;
    /****
     *登录功能
     *
     *
     */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
        return AjaxResult.success(userService.login(mobile, password));
    }






}
