package com.haopyh.ssmp.controller.utils;

import lombok.Data;

/**
 * 前后端协议统一
 */
@Data
public class R {
    private Boolean flag;
    private Object data;

    private String msg;

    public R(String msg) {
        this.msg = msg;
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
