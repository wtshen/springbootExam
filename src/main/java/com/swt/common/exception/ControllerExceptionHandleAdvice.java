package com.swt.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 17:50 2018/3/1
 * @Modified By:
 */
@ControllerAdvice
public class ControllerExceptionHandleAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandleAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(HttpServletRequest req, HttpServletResponse res, Exception e) {
        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            logger.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }

        if (e instanceof SaveException) {
            logger.error(ResultEnum.SQLException_ERROR.getMsg() + "," + e.getMessage(), e);
            return ResultUtil.error(ResultEnum.SQLException_ERROR.getCode(), "数据库访问异常");
        } else if (e instanceof NullPointerException) {
            logger.error(ResultEnum.NullPointerException_ERROR.getMsg() + "," + e.getMessage(), e);
            return ResultUtil.error(ResultEnum.NullPointerException_ERROR.getCode(), "发生空指针异常");
        } else if (e instanceof IllegalArgumentException) {
            logger.warn(ResultEnum.IllegalArgumentException_ERROR.getMsg() + "," + e.getMessage(), e);
            return ResultUtil.error(ResultEnum.IllegalArgumentException_ERROR.getCode(), "请求参数类型不匹配" + "," + e.getMessage());
        } else if (e instanceof SQLException) {
            logger.error(ResultEnum.SQLException_ERROR.getMsg() + "," + e.getMessage(), e);
            return ResultUtil.error(ResultEnum.SQLException_ERROR.getCode(), "数据库访问异常");
        } else {
            logger.error(ResultEnum.UNKONW_ERROR.getMsg() + "," + e.getMessage(), e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), "服务器代码发生异常,请联系管理员");
        }
    }
}
