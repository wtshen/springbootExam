package com.swt.dao;

import com.swt.po.MemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by wtshen on 18/2/17.
 */
@Repository
public interface MemInfoRepository extends JpaRepository<MemInfo, Integer> {

    List<MemInfo> findByName(String name);
}
