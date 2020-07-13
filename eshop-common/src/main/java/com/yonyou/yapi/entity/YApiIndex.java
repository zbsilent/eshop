package com.yonyou.yapi.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.island.eshop.common.entity.Role;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@JsonAutoDetect
public class YApiIndex {

    private int id;
    private String index_code;
    private String index_name;
    private String index_sum;
    private Date exits_time;
    private Date createTime;

}
