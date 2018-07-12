package com.swt.web.service;

import com.google.common.collect.Lists;
import com.swt.collection.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 13:37 2018/7/12
 * @Modified By:
 */
@Service
public class QueryService {
    @Autowired
    ThreadPoolTaskExecutor taskServiceExecutor;

    private List<UserInfo> query(Integer id) {
        List<UserInfo> result = Lists.newArrayList();
        UserInfo userInfo = new UserInfo();
        try {
            TimeUnit.SECONDS.sleep(2);
            userInfo.setId(id);
            userInfo.setAge(id + 20);
            userInfo.setName("name" + id);
            result.add(userInfo);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<UserInfo> threadHandle(List<Integer> ids) {
        System.out.println("thread start===");
        List<Future<List<UserInfo>>> futures = Lists.newArrayList();
        final CountDownLatch latch = new CountDownLatch(ids.size());
        ids.forEach(id -> {
            Future<List<UserInfo>> future = taskServiceExecutor.submit(() -> {
                LocalDateTime now = LocalDateTime.now();
                try {
                    return query(id);
                } finally {
                    System.out.println("单个现成耗时：" + Duration.between(now, LocalDateTime.now()).toMillis());
                    latch.countDown();
                }
            });
            futures.add(future);
        });

        List<UserInfo> userInfoList = Lists.newArrayList();
        try {
            latch.await();
            futures.forEach(f -> {
                try {
                    userInfoList.addAll(f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return userInfoList;
    }
}
