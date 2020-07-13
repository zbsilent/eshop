package com.yonyou.openapi.quote.mapper;

 import com.yonyou.openapi.quote.entity.OpenApiQuote;
 import org.apache.ibatis.annotations.*;
 import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OpenApiQuoteDao {


    @Select("SELECT * FROM openapi_quote where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true, jdbcType = JdbcType.INTEGER),
            @Result(property = "exits_time", column = "exits_time", jdbcType = JdbcType.DATE),
            @Result(property = "createTime", column = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "quote_code", column = "quote_code"),
            @Result(property = "quote_name", column = "quote_name"),
            @Result(property = "quote_sum", column = "quote_sum"),
            @Result(property = "openapiquoteItems", column = "id",javaType= List.class,  many = @Many(select = "com.yonyou.openapi.quote.mapper.OpenApiQuoteItemDao.findByQuoteId"))
    })
    List<OpenApiQuote> findAll(@Param("id")Integer id);
}
