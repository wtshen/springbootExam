package com.swt.service;

import com.swt.model.memInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swt.dao.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wtshen on 18/2/17.
 */
@Service
public class memService {

    @Autowired
    memInfoRepository memInfoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addTwoMemInfo() throws Exception {
        memInfo meminfo1 = new memInfo();
        meminfo1.setName("swt10");
        memInfo result = memInfoRepository.save(meminfo1);

        if (result != null) {
            throw new Exception("add error!");
        }

        memInfo meminfo2 = new memInfo();
        meminfo2.setName("swt11");
        memInfoRepository.save(meminfo2);
    }
}
