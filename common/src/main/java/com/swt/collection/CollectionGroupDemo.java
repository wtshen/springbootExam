package com.swt.collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午10:58 18/8/1.
 * @Modified By:
 */
public class CollectionGroupDemo {
    public static void main(String[] args) {
        List<UserInfo> userInfoList = Lists.newArrayList();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setAge(0);
        userInfoList.add(userInfo);

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1);
        userInfo1.setAge(0);
        userInfoList.add(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setAge(1);
        userInfoList.add(userInfo2);

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setId(2);
        userInfo3.setAge(3);
        userInfoList.add(userInfo3);

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setId(2);
        userInfo4.setAge(4);
        userInfoList.add(userInfo4);

        Optional<UserInfo> collect1 =
                userInfoList.stream().collect(Collectors.maxBy(Comparator.comparing(UserInfo::getAge)));
        Map<Integer, List<UserInfo>> collect =
                userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getId));

        Optional<UserInfo> collect2 = userInfoList.stream().collect(maxBy(comparing(UserInfo::getAge)));

        System.out.println(collect2);

    }

}
