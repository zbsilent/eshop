package com.island.eshop.common.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * 〈响应实体〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Data
@JsonAutoDetect
public class Result {

    private int code;
    private String message;
    private Object data;

}
