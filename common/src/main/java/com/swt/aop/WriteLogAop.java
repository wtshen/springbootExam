package com.swt.aop;

import com.swt.annotation.WriteLogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: wtshen
 * @Description: 日志记录切面
 * @Date: Created in 上午6:50 18/8/25.
 * @Modified By:
 */

/**
 * 把当前类标识为一个切面供容器读取
 */
@Aspect
@Component
public class WriteLogAop {

    @Pointcut(value = "@annotation(com.swt.annotation.WriteLogAnnotation)")
    public void writeLog() {
    }

    /**
     * 标识一个前置增强功能,相当于 BeforeAdvice 功能
     *
     * @param joinPoint
     */
    @Before("writeLog()")
    public void before(JoinPoint joinPoint) {
        // 接受到请求,记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("URL:" + request.getRequestURL().toString());
        System.out.println("Request Method:" + request.getMethod());
        System.out.println("IP:" + request.getRemoteAddr());
        System.out.println("CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS:" + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 后置增强,相当于 AfterRetuiningAdvice,方法退出时执行
     *
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "writeLog()")
    public void afterReturning(Object ret) {
        System.out.println("方法返回值:" + ret);
    }

    /**
     * 后置异常通知,相当于ThrowsAdvice
     *
     * @param joinPoint
     */
    @AfterThrowing("writeLog()")
    public void throwException(JoinPoint joinPoint) {
        System.out.println("方法异常时执行.....");
    }

    /**
     * 后置最终通知,final 增强,不管是抛出异常还是正常退出都会执行
     */
    @After("writeLog()")
    public void after(JoinPoint joinPoint) {
        System.out.println("方法最后执行...");
    }

    /**
     * 环绕增强,相当于 MethodInterceptor
     *
     * @param proceedingJoinPoint
     * @param writeLogAnnotation
     * @return
     */
    @Around("@annotation(writeLogAnnotation)")
    public Object arount(ProceedingJoinPoint proceedingJoinPoint, WriteLogAnnotation writeLogAnnotation) {
        System.out.println("方法环绕开始:" + writeLogAnnotation.logTitle());
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("方法环绕proceed,结果是:" + result);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
