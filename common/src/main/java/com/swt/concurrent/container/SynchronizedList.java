package com.swt.concurrent.container;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:49 18/3/27.
 * @Modified By:
 */
public class SynchronizedList {
    List<String> list = Lists.newArrayList();
    List<String> syncList = Collections.synchronizedList(list);
}
