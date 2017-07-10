package com.adamzfc.infrastructure.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by adamzfc on 2017/7/10.
 */
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 2404372373182554123L;
    private int code;
    private String msg;
    private String devMsg;
    public AppException() {
        this(Error.UNKNOWN_EXCEPTION);
    }

    public AppException(Error code) {
        code = code == null ? Error.UNKNOWN_EXCEPTION : code;
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public AppException(Error code, String exMsg) {
        this(code);
        this.msg = String.format(code.getMsg(), exMsg);
        this.devMsg = exMsg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public String getDevMsg() {
        return devMsg;
    }
}
