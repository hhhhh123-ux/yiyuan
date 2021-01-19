package com.gzq.yiyuan.service.Impl;

import com.gzq.yiyuan.dao.RoleDao;
import com.gzq.yiyuan.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SongYC
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDao roleDao;
}
