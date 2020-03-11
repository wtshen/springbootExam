package com.swt.io;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 3:10 PM 2020/3/9.
 * @Modified By:
 */
@Service
public class InputStreamService {
    public String readFile() {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/template/zzmail.html")) {
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
