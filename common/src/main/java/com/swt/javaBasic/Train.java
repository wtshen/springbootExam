package com.swt.javaBasic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 13:32 2018/6/29
 * @Modified By:
 */
@Getter
@Setter
@ToString
public class Train {
    private Integer trainId;
    private String trainName;
    private List<Seat> seats;
}
