package com.swt.exception;

import java.io.Serializable;

/**
 * @Author: wtshen
 * @Description: http请求返回的最外层对象
 * @Date: Created in 17:53 2018/3/1
 * @Modified By:
 */
public class Result<T> implements Serializable {
    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String message;

    /**
     * 具体的内容.
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
