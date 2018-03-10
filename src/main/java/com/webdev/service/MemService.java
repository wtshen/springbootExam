package com.webdev.service;

import com.webdev.common.exception.ResultEnum;
import com.webdev.common.exception.SaveException;
import com.webdev.model.MemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webdev.dao.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wtshen on 18/2/17.
 */
@Service
public class MemService {

    @Autowired
    MemInfoRepository memInfoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addTwoMemInfo() {
        MemInfo meminfo1 = new MemInfo();
        meminfo1.setName("swt10");
        MemInfo result = memInfoRepository.save(meminfo1);

        if (result != null) {
            throw new SaveException(ResultEnum.SQLException_ERROR);
        }

        MemInfo meminfo2 = new MemInfo();
        meminfo2.setName("swt11");
        memInfoRepository.save(meminfo2);
    }
}
