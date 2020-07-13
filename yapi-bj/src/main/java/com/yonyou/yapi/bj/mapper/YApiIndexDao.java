package com.yonyou.yapi.bj.mapper;

import com.yonyou.yapi.entity.YApiIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface YApiIndexDao {


    @Select("SELECT * FROM yapi_index")
    @Results({
            @Result(property = "id", column = "id", id = true, jdbcType = JdbcType.INTEGER),
            @Result(property = "exits_time", column = "exits_time", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "createTime", column = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "index_code", column = "index_code"),
            @Result(property = "index_name", column = "index_name"),
            @Result(property = "index_sum", column = "index_sum")

    })
    List<YApiIndex> findAll();
}
