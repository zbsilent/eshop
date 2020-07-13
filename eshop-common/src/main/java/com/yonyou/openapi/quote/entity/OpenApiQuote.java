package com.yonyou.openapi.quote.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.island.eshop.common.entity.Role;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @author zbsilent
 * 报价单实体
 */
@Data
@JsonAutoDetect
public class OpenApiQuote {

    private int id;
    private String quote_code;
    private String quote_name;
    private String quote_sum;
    private Date exits_time;
    private Date createTime;
    private Set<OpenApiQuoteItem> openapiquoteItems;

}
