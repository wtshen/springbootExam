package com.swt.jvm.memory;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:内存泄漏
 * @Date: Created in 10:25 PM 2020/5/19.
 * @Modified By:
 */
public class MemoryLeak {
    static List<byte[]> bytes = Lists.newArrayList();

    public static void mmoLeak() {
        while (true) {
            byte[] bytes1 = new byte[1024 * 1024 * 4];
            bytes.add(bytes1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        mmoLeak();
    }
}
