package com.gzq.yiyuan.service;




import java.util.List;

/**
 * @author SongYC
 */
public interface UserRoleService {

    void insert( Long userId, List<String> roleIds);
}
