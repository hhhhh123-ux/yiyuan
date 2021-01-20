package com.gzq.yiyuan.service.Impl;

import com.gzq.yiyuan.dao.RoleDao;
import com.gzq.yiyuan.dao.UserRoleDao;
import com.gzq.yiyuan.entiy.Role;
import com.gzq.yiyuan.service.RoleService;
import com.gzq.yiyuan.utils.CurrentUserUtils;
import com.gzq.yiyuan.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author SongYC
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDao roleDao;
    @Resource
    UserRoleDao userRoleDao;
    @Override
    public int insertSelective(Role record) throws ParseException {
        record.setCreatetime(DateUtil.parseStringToDate(DateUtil.getDate()));
        record.setCreator(String.valueOf(CurrentUserUtils.getCurrentUser()));
        return roleDao.insertSelective(record);
    }

    @Override
    public List<Role> selectByPrimaryKey(Long id) {
        List<Role> roleList=new ArrayList<>();
        List<String> ids=userRoleDao.findUserId(id);
        for(String string:ids) {
        Role role=roleDao.selectByPrimaryKey(Long.valueOf(string));
        roleList.add(role);
        }
        return roleList;
    }
}
