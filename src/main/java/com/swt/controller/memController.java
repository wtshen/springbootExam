package com.swt.controller;

import com.swt.model.MemInfo;
import com.swt.service.MemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.swt.dao.*;

import java.util.List;

/**
 * Created by wtshen on 18/2/17.
 */
@RestController
public class MemController {
    @Autowired
    private MemInfoRepository memInfoRepository;

    @Autowired
    private MemService MemService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/memlist")
    public List<MemInfo> memInfoList() {
        return memInfoRepository.findAll();
    }

    /**
     * 新增用户
     *
     * @param name
     * @return
     */
    @PostMapping("/memadd")
    public MemInfo memAdd(@RequestParam("name") String name) {
        MemInfo MemInfo = new MemInfo(name);
        return memInfoRepository.save(MemInfo);
    }

    /**
     * 更新数据
     *
     * @param id
     * @param name
     * @return
     */
    @PutMapping("/memupdate/{id}")
    public MemInfo memUpdate(@PathVariable("id") Integer id,
                             @RequestParam("name") String name) {
        MemInfo MemInfo = new MemInfo(name);
        MemInfo.setId(id);
        return memInfoRepository.save(MemInfo);
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
    public MemInfo getOneMem(@PathVariable("id") Integer id) {
        return memInfoRepository.findOne(id);
    }

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    @GetMapping("/getbyage/{name}")
    public List<MemInfo> getByAge(@PathVariable("name") String name) {
        return memInfoRepository.findByName(name);
    }

    @PostMapping("addtwoMemInfo")
    public void addTwoMemInfo() {
        try {
            MemService.addTwoMemInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
