package com.gzq.yiyuan.controller;

import com.gzq.yiyuan.entiy.Role;
import com.gzq.yiyuan.result.AjaxResult;
import com.gzq.yiyuan.service.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author SongYC
 */
@Api(value = "角色功能")
@Slf4j
@RestController
@RequestMapping("/role/form")
public class RoleController {
    @Autowired
    RoleService roleService;


    @PostMapping("/add")
    private AjaxResult add(@RequestBody Role role) throws ParseException {
        return AjaxResult.success(roleService.insertSelective(role));
    }
}
