package com.yonyou.openapi.quote.mapper;

import com.yonyou.openapi.quote.entity.OpenApiQuoteItem;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OpenApiQuoteItemDao {

    @Select("select t.* from openapi_quote_item t where t.quote_id = #{quote_id,jdbcType=INTEGER}")
    @Results({
            @Result(property = "id", column = "id", id = true, jdbcType = JdbcType.INTEGER),
            @Result(property = "quote_id", column = "quote_id", jdbcType = JdbcType.INTEGER),
            @Result(property = "createTime", column = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "quoteitem_code", column = "quoteitem_code"),
            @Result(property = "quoteitem_name", column = "quoteitem_name"),
            @Result(property = "quoteitem_num", column = "quoteitem_num")
    })
    List<OpenApiQuoteItem> findByQuoteId(@Param("quote_id")Integer quote_id);
}
