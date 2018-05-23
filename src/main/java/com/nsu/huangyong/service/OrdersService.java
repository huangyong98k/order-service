package com.nsu.huangyong.service;

import com.nsu.huangyong.model.OrdersReq;
import com.nsu.huangyong.pojo.Orders;
import com.nsu.huangyong.vo.CommonResp;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
public interface OrdersService {
    /**
     * 生成订单
     */
    CommonResp addOrders(OrdersReq ordersReq);
    /**
     * 查询订单
     */
    List<Orders> findOrdersByMemberNo(String memberNo);
    /**
     * 更新状态
     */
    CommonResp updateStatus(String orderNo, Integer status);
    /**
     * 查看订单状态
     */
    Integer findOrderStatus(String orderNo);
}
