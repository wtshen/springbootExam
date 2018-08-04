package com.swt.collection;

import com.google.common.collect.Lists;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 上午9:47 18/8/4.
 * @Modified By:
 */
public class CollectionFliter {
    public static void main(String[] args) {

        Random random = new Random(1);
        List<UserInfo> userInfoList = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(random.nextInt(10));
            userInfo.setAge(random.nextInt(10) + random.nextInt(20));
            userInfo.setName("user" + random.nextInt(10));
            userInfoList.add(userInfo);
        }

        System.out.println(userInfoList);

        String sourceName = "user3|user4";
        int age = 15;

        List<UserInfo> collect1 = userInfoList.stream()
                .filter(x -> fliterUserInfo(x, sourceName, age)).collect(Collectors.toList());
        System.out.println("Result:" + collect1);
    }

    private static boolean fliterUserInfo(UserInfo p, String name, int age) {
        boolean result = false;
        if (StringUtils.isNotEmpty(name)) {
            String[] splits = name.split("\\|");
            for (String split : splits) {
                if (p.getName().contains(split)) {
                    result = true;
                    break;
                }
            }
        }

        if (age > 0) {
            if (p.getAge().equals(age)) {
                result = result & true;
            } else {
                result = false;
            }
        }

        return result;
    }
}
