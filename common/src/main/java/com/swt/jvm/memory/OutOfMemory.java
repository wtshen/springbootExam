package com.swt.jvm.memory;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:内存溢出
 * @Date: Created in 10:25 PM 2020/5/19.
 * @Modified By:
 */
public class OutOfMemory {
    public static void oom() {
        List<byte[]> bytes = Lists.newArrayList();
        while (true) {
            byte[] bytes1 = new byte[1024 * 1024 * 1];
            bytes.add(bytes1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        oom();
    }
}
