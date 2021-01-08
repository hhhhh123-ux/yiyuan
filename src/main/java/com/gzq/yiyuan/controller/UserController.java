package com.gzq.yiyuan.controller;


import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.result.AjaxResult;
import com.gzq.yiyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(User user,Model model){
        model.addAttribute(user);
        return "index";
    }
    /****
     *注册功能
     *
     *
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResult add(@RequestBody User user) {
        return AjaxResult.success(userService.insertSelective(user));
    }
    /****
     *注册功能
     *
     *
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult Login(@RequestBody User user) {
        return AjaxResult.success(userService.insertSelective(user));
    }


}
