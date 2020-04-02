package com.island.eshop.auth.dao;

import com.island.eshop.common.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈权限Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Repository
//@Mapper
public interface PermissionDao {

    /**
     * 根据角色id查找权限列表
     * @param roleId 角色id
     * @return 权限列表
     */

    List<Permission> findByRoleId(Integer roleId);
}
