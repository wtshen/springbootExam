package com.swt.web;

import com.swt.web.service.QueryService;
import com.swt.web.service.ReadFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartApplication.class)
public class ServiceTest {

    @Autowired
    QueryService queryService;
    @Autowired
    ReadFileService readFileService;

    @Test
    public void  readFile(){
      System.out.println(readFileService.readFile());
    }

}
