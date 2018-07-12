package com.swt.concurrent.threadpool.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wtshen
 * @Description:
 * 线程池配置类，为了让springboot能扫描到，如果再springboot启动类中把顶层包名加入扫描
 * 实现并发、异步等操作时，通常都会使用到ThreadPoolTaskExecutor,是一个spring的线程池技术，它是使用jdk中的java.util.concurrent.ThreadPoolExecutor进行实现。
 * 提交任务
        无返回值的任务使用execute(Runnable)
        有返回值的任务使用submit(Runnable)
   配置线程个数
        如果是CPU密集型任务，那么线程池的线程个数应该尽量少一些，一般为CPU的个数+1条线程。
        如果是IO密集型任务，那么线程池的线程可以放的很大，如2*CPU的个数。
        对于混合型任务，如果可以拆分的话，通过拆分成CPU密集型和IO密集型两种来提高执行效率；如果不能拆分的的话就可以根据实际情况来调整线程池中线程的个数。
 * @Date: Created in 19:29 2018/7/11
 * @Modified By:
 */
@Configuration
public class ExecutorConfig {
    @Bean
    public ThreadPoolTaskExecutor taskServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(3);
        // 设置最大线程数
        executor.setMaxPoolSize(10);
        // 设置队列容量
        executor.setQueueCapacity(20);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("hello-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
