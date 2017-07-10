package com.adamzfc.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by adamzfc on 2017/7/10.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private boolean success;
    private String msg;
    private String devMsg;
    private int code;
    private Object data;
}
