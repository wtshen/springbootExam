package com.swt.collection;

import com.google.common.collect.Lists;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午10:58 18/8/1.
 * @Modified By:
 */
public class CollectionGroupDemo {
    public static void main(String[] args) {
        Random random = new Random(1);
        List<UserInfo> userInfoList = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(random.nextInt(10));
            userInfo.setAge(random.nextInt(10)+random.nextInt(20));
            userInfo.setName("user"+random.nextInt(10));
            userInfoList.add(userInfo);
        }

        //String sourceName = "user1|user2";
        //List<UserInfo> collect1 = userInfoList.stream().filter(x -> sourceName.contains(x.getName())).collect(Collectors.toList());

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Map<Integer, List<UserInfo>> collect =
                userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getId));

        //userInfoList = null;

        Set<UserInfo> userInfos = new HashSet<>();
        for (Map.Entry<Integer, List<UserInfo>> integerListEntry : collect.entrySet()) {
            Optional<UserInfo> maxCollect = integerListEntry.getValue().stream().collect(maxBy(comparing(UserInfo::getAge)));
            Optional<UserInfo> minCollect = integerListEntry.getValue().stream().collect(minBy(comparing(UserInfo::getAge)));

            UserInfo tmpUserInfo = new UserInfo();
            tmpUserInfo.setId(integerListEntry.getKey());
            tmpUserInfo.setAge(maxCollect.get().getAge() - minCollect.get().getAge() + 1);
            userInfos.add(tmpUserInfo);
        }

        stopWatch.stop();

        System.out.println(userInfoList);
        System.out.println(userInfos);
        System.out.println(stopWatch.prettyPrint());

    }
}
