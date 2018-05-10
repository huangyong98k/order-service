package com.nsu.huangyong.service;

import com.nsu.huangyong.pojo.Invoice;
import com.nsu.huangyong.pojo.Logistics;
import com.nsu.huangyong.vo.CommonResp;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
public interface LogisticsService {
    /**
     * 生成物流信息
     */
    CommonResp initLogistics(String invoice);
    /**
     * 生成物流信息
     */
    CommonResp updateLogistics(String logisticsNo,String nowAddress);
    /**
     * 查询物流信息
     */
    List<Logistics> findLogisticsByMemberNo(String memberNo);
}
