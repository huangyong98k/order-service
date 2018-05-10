package com.nsu.huangyong.dao;

import com.nsu.huangyong.pojo.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
public interface LogisticsDao extends JpaRepository<Logistics,Long>{
    /**
     * 更新物流信息
     */
    @Modifying
    @Query(value = "update logistics set now_address = ?1,status = ?2 where  logistics_no = ?3",nativeQuery = true)
    void updateLogistics(String nowAddress, Integer status, String logisticsNo);

    List<Logistics>  findLogisticsByMemberNo(String memberNo);
}
