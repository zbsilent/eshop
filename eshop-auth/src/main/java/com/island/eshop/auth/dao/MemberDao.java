package com.island.eshop.auth.dao;


import com.island.eshop.common.entity.Member;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈用户Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Repository
//@Mapper
public interface MemberDao {

    /**
     * property 配置文件内容 及JavaBean内容
     * column 数据库内容
     *
     * @param memberName
     * @return
     *
     *
     */
//    @Select("SELECT * FROM es_member where member_name = #{memberName,jdbcType=VARCHAR}")
//    @Results({
//            @Result(property = "id", column = "id",id=true,jdbcType = JdbcType.INTEGER),
//            @Result(property = "birthday", column = "birthday",jdbcType = JdbcType.TIMESTAMP),
//             @Result(property = "createTime", column = "createTime",jdbcType = JdbcType.TIMESTAMP),
//            @Result(property = "email", column = "email"),
//            @Result(property = "memberName", column = "member_name"),
//            @Result(property = "sex", column = "sex" ,jdbcType = JdbcType.TINYINT),
//            @Result(property = "mobile", column = "mobile"),
//            @Result(property = "password", column = "password"),
//            @Result(property = "roles", column = "id",javaType= List.class,  many = @Many(select = "com.island.eshop.auth.dao.RoleDao.findByMemberId"))
//
//    })

    Member findByMemberName(@Param("memberName") String memberName);
}
