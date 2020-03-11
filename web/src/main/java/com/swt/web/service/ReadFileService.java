package com.swt.web.service;

import com.swt.io.InputStreamService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:25 PM 2020/3/9.
 * @Modified By:
 */
@Service
public class ReadFileService {
    @Autowired
    InputStreamService inputStreamService;
    public String readFile() {
        return inputStreamService.readFile();
    }
}
