package com.swt.service;

import com.swt.model.MemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swt.dao.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wtshen on 18/2/17.
 */
@Service
public class MemService {

    @Autowired
    MemInfoRepository memInfoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addTwoMemInfo() throws Exception {
        MemInfo meminfo1 = new MemInfo();
        meminfo1.setName("swt10");
        MemInfo result = memInfoRepository.save(meminfo1);

        if (result != null) {
            throw new Exception("add error!");
        }

        MemInfo meminfo2 = new MemInfo();
        meminfo2.setName("swt11");
        memInfoRepository.save(meminfo2);
    }
}
