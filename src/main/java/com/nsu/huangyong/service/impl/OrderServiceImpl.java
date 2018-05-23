package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.NFruitsUtils;
import com.nsu.huangyong.dao.OrdersDao;
import com.nsu.huangyong.model.OrdersReq;
import com.nsu.huangyong.pojo.Orders;
import com.nsu.huangyong.service.OrdersService;
import com.nsu.huangyong.vo.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public CommonResp addOrders(OrdersReq ordersReq) {
        try {
            ordersDao.save(transferToOrders(ordersReq));
        } catch (Exception e) {
            log.error("error:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常！！！");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public List<Orders> findOrdersByMemberNo(String memberNo) {
        return ordersDao.findAllByMemberNo(memberNo);
    }

    @Override
    @Transactional
    public CommonResp updateStatus(String orderNo, Integer status) {
        try {
            ordersDao.updateStatus(orderNo,status);
        } catch (Exception e) {
            log.error("error:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常！！！");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public Integer findOrderStatus(String orderNo) {
        Orders orders = ordersDao.findOrdersByOrderNo(orderNo);
        if (orders == null){
            return -1;
        }
        return orders.getStatus();
    }

    static Orders transferToOrders(OrdersReq ordersReq){
        Orders o = new Orders();
        o.setMemberNo(ordersReq.getMemberNo());
        o.setDistributionWay(ordersReq.getDistributionWay());
        o.setInvoiceType(ordersReq.getInvoiceType());
        o.setInvoiceTitle(ordersReq.getInvoiceTitle());
        o.setInvoiceContent(ordersReq.getInvoiceContent());
        o.setGoodsNo(ordersReq.getGoodsNo());
        o.setGoodsNumber(ordersReq.getGoodsNumber());
        o.setFreight(ordersReq.getFreight());
        o.setTotalNum(ordersReq.getTotalNum());
        o.setReceivAddress(ordersReq.getReceivAddress());
        o.setReceiveName(ordersReq.getReceivName());
        o.setPhone(ordersReq.getPhone());
        o.setRemark(ordersReq.getRemark());
        o.setOrderNo("ODS"+NFruitsUtils.identifier());
        o.setCreateTime(NFruitsUtils.getCurrentTime());
        o.setStatus(0);
        return o;
    }
}
