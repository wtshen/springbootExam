package com.swt.jvm.gc;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:44 PM 2020/5/8.
 * @Modified By:
 */
public class BigObject {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> bytes = Lists.newArrayList();
        while (true) {
            bytes.add(new byte[1024 * 1024 * 3]);
            Thread.sleep(100);
        }
    }
}
