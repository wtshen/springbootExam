package com.webdev.dao;

import com.webdev.model.MemInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by wtshen on 18/2/17.
 */
public interface MemInfoRepository extends JpaRepository<MemInfo, Integer> {

    List<MemInfo> findByName(String name);
}
