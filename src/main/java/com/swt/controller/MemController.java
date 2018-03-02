package com.swt.controller;

import com.google.common.base.Preconditions;
import com.swt.common.exception.Result;
import com.swt.common.exception.ResultUtil;
import com.swt.dao.MemInfoRepository;
import com.swt.model.MemInfo;
import com.swt.service.MemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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
    public Result<List<MemInfo>> memInfoList() {
        if (CollectionUtils.isEmpty(memInfoRepository.findAll())) {
            throw new RuntimeException();
            //return ResultUtil.error(ResultEnum.SQLException_ERROR.getCode(), ResultEnum.SQLException_ERROR.getMessage());
        } else {
            return ResultUtil.success();
        }
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
        Preconditions.checkArgument(id > 0,"用户ID不能为空");
        return memInfoRepository.findOne(id);
    }

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    @GetMapping("/getbyage/{name}")
    public Result<List<MemInfo>> getByAge(@PathVariable("name") String name) {
        List<MemInfo> list = memInfoRepository.findByName(name);
        return ResultUtil.success(list);
    }

    @PostMapping("addtwoMemInfo")
    public void addTwoMemInfo() {
        MemService.addTwoMemInfo();
    }
}
