package com.gzq.yiyuan.service.Impl;

import com.google.common.collect.Lists;
import com.gzq.yiyuan.dao.UserRoleDao;
import com.gzq.yiyuan.entiy.mid.UserRole;
import com.gzq.yiyuan.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaozhiqiang
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    UserRoleDao userRoleDao;

    @Override
    public void insert(Long userId, List<String> roleIds) {
        List<String> list = userRoleDao.findUserId(userId);
        List<String> list1 = userRoleDao.findUserId(userId);
        List<String> stringList1 = list1(list, roleIds);
        for (String s : stringList1) {
            userRoleDao.deleteRoleIdUserId(userId, Long.valueOf(s));
        }
        List<String> stringList = list(list1, roleIds);
        for (String s : stringList) {
            UserRole userRole=new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(Long.valueOf(s));
            userRoleDao.insertSelective(userRole);
        }
}

    public List<String> list1(List<String> list, List<String> roleIds) {
        List<String> list1 = new ArrayList<>();
        if (roleIds.containsAll(list)) {
            assert true;
        } else {
            list.removeAll(roleIds);
            System.out.println(list);
            for (String s : list) {
                list1.add(s);
            }
        }
        return list1;
    }
    public List<String> list(List<String> list, List<String> roleIds) {
        List<String> list1 = new ArrayList<>();
        if (list.containsAll(roleIds)) {
            assert true;
        } else {
            roleIds.removeAll(list);
            System.out.println(roleIds);
            for (String s : roleIds) {
                list1.add(s);
            }
        }

        return list1;
    }
}