package com.gzq.yiyuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.result.AjaxResult;
import com.gzq.yiyuan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "注册功能")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserRegisterController {
    @Autowired
    UserService userService;

    /****
     *注册功能
     *
     *
     */
    @ApiOperation(value = "注册实现")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public AjaxResult register(@RequestBody User user) {
        JSONObject object=new JSONObject();
        object.put("user",user);
        log.info("注册人",user);
       try{
           return AjaxResult.success(userService.insertSelective(user));
       }catch(Exception e){
           log.error("个人用户注册,异常：" + e.toString());
           return AjaxResult.failed();
       }
    }

}
