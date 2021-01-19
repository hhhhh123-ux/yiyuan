package com.gzq.yiyuan.controller;

import com.gzq.yiyuan.service.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
