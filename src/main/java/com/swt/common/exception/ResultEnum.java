package com.swt.common.exception;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 21:04 2018/3/1
 * @Modified By:
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    NullPointerException_ERROR(100, "发生空指针异常"),
    IllegalArgumentException_ERROR(101, "请求参数类型不匹配"),
    SQLException_ERROR(101, "数据库访问异常"),
    UNKONW_ERROR(-100, "服务器代码发生异常,请联系管理员");

    Integer code;
    String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    }
