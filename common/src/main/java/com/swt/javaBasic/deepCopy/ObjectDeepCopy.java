package com.swt.javaBasic.deepCopy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author: wtshen
 * @Description: 利用序列化完成深拷贝
 * @Date: Created in 13:28 2018/6/29
 * @Modified By:
 */
public class ObjectDeepCopy {
    public static void main(String[] args) {
        List<Seat> seatList = Lists.newArrayList();
        Seat seat = new Seat();
        seat.setSeatId(11);
        seat.setSeatName("一等座");
        seatList.add(seat);

        List<Train> trainList = Lists.newArrayList();
        Train train1 = new Train();
        train1.setTrainId(1);
        train1.setTrainName("动车");
        train1.setSeats(seatList);
        trainList.add(train1);

        Train train2 = new Train();
        train2.setTrainId(2);
        train2.setTrainName("高铁");
        train2.setSeats(seatList);
        trainList.add(train2);

        final Type type = new TypeReference<List<Train>>() {
        }.getType();
        List<Train> deepCopyTrainList = JSON.parseObject(JSON.toJSONString(trainList), type);

        if (CollectionUtils.isNotEmpty(deepCopyTrainList)) {
            for (Train train : deepCopyTrainList) {
                train.setTrainName(String.format("%s_deepcopy", train.getTrainName()));
            }
        }

        System.out.printf("源：%s%n", trainList);
        System.out.printf("深拷贝：%s%n", deepCopyTrainList);
    }
}
