package com.swt.common.exception;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:11 2018/3/2
 * @Modified By:
 */
public class SaveException extends RuntimeException {
    private Integer code;

    public SaveException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
