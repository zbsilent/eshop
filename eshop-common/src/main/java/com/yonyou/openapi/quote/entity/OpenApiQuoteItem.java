package com.yonyou.openapi.quote.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Date;

@Data
@JsonAutoDetect
public class OpenApiQuoteItem {

    private String id;
    private String quote_id;
    private String quoteitem_code;
    private String quoteitem_name;
    private String quoteitem_num;
    private Date createTime;

}
