package com.island.eshop.auth.dao;


import com.island.eshop.common.entity.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈角色Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Repository
//@Mapper
public interface RoleDao {

    /**
     * 根据用户id查找角色列表
     *
     * @param memberId 用户id
     * @return 角色列表
     */
//    @Select("select r.* from es_member_role mr,es_role r where mr.role_id = r.id and mr.member_id = #{memberId,jdbcType=INTEGER}")
//    @Results(
//            value = {
//                    @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
//                    @Result(column = "valid", property = "valid", jdbcType = JdbcType.TINYINT),
//                    @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
//                    @Result(column = "updateTime", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
//
//                    @Result(column = "id", property = "permissions", many = @Many(select = "com.island.eshop.auth.dao.PermissionDao.findByRoleId"), javaType = List.class)
//
//            }
//    )
    List<Role> findByMemberId(@Param("memberId") Integer memberId);
}
