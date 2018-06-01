package com.swt.web.service;


import com.swt.dao.MemInfoRepository;
import com.swt.exception.ResultEnum;
import com.swt.exception.SaveException;
import com.swt.po.MemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wtshen on 18/2/17.
 */
@Service
public class MemService {

    /*@Autowired
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
    }*/
}
