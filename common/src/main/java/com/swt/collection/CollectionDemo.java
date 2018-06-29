package com.swt.collection;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:40 18/3/5.
 * @Modified By:
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<UserInfo> userInfoList = Lists.newArrayList();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(100);
        userInfo1.setName("aaa");
        userInfo1.setAge(10);
        userInfoList.add(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(200);
        userInfo2.setName("aaa");
        userInfo2.setAge(10);
        userInfoList.add(userInfo2);

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setId(300);
        userInfo3.setName("aaa");
        userInfo3.setAge(10);
        userInfoList.add(userInfo3);

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setId(100);
        userInfo4.setName("aaa");
        userInfo4.setAge(20);
        userInfoList.add(userInfo4);

        // 去重，需要重写对象的equals、hashCode方法
        List<UserInfo> distinctUserInfoList = userInfoList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctUserInfoList);

    }

}
