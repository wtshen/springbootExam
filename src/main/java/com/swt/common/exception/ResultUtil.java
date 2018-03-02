package com.swt.common.exception;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 20:51 2018/3/1
 * @Modified By:
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("success");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
