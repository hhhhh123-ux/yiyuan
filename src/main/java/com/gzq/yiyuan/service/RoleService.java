package com.gzq.yiyuan.service;

import com.gzq.yiyuan.entiy.Role;

import java.text.ParseException;
import java.util.List;

/**
 * @author SongYC
 */
public interface RoleService {
    int insertSelective(Role record) throws ParseException;
    /**
     * @author SongYC
     */
    List<Role> selectByPrimaryKey(Long id);
}
