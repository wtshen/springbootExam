package com.swt.dao;

import com.swt.model.memInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by wtshen on 18/2/17.
 */
public interface memInfoRepository extends JpaRepository<memInfo, Integer> {

    List<memInfo> findByName(String name);
}
