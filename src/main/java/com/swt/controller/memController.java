package com.swt.controller;

import com.swt.model.memInfo;
import com.swt.service.memService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.swt.dao.*;

import java.util.List;

/**
 * Created by wtshen on 18/2/17.
 */
@RestController
public class memController {
    @Autowired
    private memInfoRepository memInfoRepository;

    @Autowired
    private memService memService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/memlist")
    public List<memInfo> memInfoList() {
        return memInfoRepository.findAll();
    }

    /**
     * 新增用户
     *
     * @param name
     * @return
     */
    @PostMapping("/memadd")
    public memInfo memAdd(@RequestParam("name") String name) {
        memInfo memInfo = new memInfo(name);
        return memInfoRepository.save(memInfo);
    }

    /**
     * 更新数据
     *
     * @param id
     * @param name
     * @return
     */
    @PutMapping("/memupdate/{id}")
    public memInfo memUpdate(@PathVariable("id") Integer id,
                             @RequestParam("name") String name) {
        memInfo memInfo = new memInfo(name);
        memInfo.setId(id);
        return memInfoRepository.save(memInfo);
    }

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/memdel/{id}")
    public void memDelete(@PathVariable("id") Integer id) {
        memInfoRepository.delete(id);
    }

    /**
     * 根据ID查询一个用户
     *
     * @param id
     * @return
     */
    @GetMapping("/getbyid/{id}")
    public memInfo getOneMem(@PathVariable("id") Integer id) {
        return memInfoRepository.findOne(id);
    }

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    @GetMapping("/getbyage/{name}")
    public List<memInfo> getByAge(@PathVariable("name") String name) {
        return memInfoRepository.findByName(name);
    }

    @PostMapping("addtwoMemInfo")
    public void addTwoMemInfo() {
        try {
            memService.addTwoMemInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
