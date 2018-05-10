package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.NFruitsUtils;
import com.nsu.huangyong.dao.GoodsDao;
import com.nsu.huangyong.dao.InvoiceDao;
import com.nsu.huangyong.dao.OrdersDao;
import com.nsu.huangyong.dao.SellerDao;
import com.nsu.huangyong.pojo.Goods;
import com.nsu.huangyong.pojo.Invoice;
import com.nsu.huangyong.pojo.Orders;
import com.nsu.huangyong.pojo.Seller;
import com.nsu.huangyong.service.InvoiceService;
import com.nsu.huangyong.service.LogisticsService;
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
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private SellerDao sellerDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private LogisticsService logisticsService;
    @Override
    public CommonResp initInvoice(String orderNo, String memerNo, String sellNo) {
        Orders order = ordersDao.findOrdersByOrderNo(orderNo);
        if (order.getStatus() != 1){
            return new CommonResp(CommonRespCode.FAIL,"服务异常！！！");
        }
        Goods goods = goodsDao.findGoodsByGoodsNo(order.getGoodsNo());
        Seller seller = sellerDao.findSellerBySellerNo(sellNo);
        invoiceDao.save(transferToInvoice(order,memerNo,goods.getTitle(),seller));
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public List<Invoice> findListBySellerNo(String sellerNo) {
        return invoiceDao.findAllBySellerNo(sellerNo);
    }

    @Override
    @Transactional
    public CommonResp service(String invoiceNo) {
        try {
            invoiceDao.updateStatus(invoiceNo,1);
        } catch (Exception e) {
            log.error("error msg:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常！！！");
        }
        return logisticsService.initLogistics(invoiceNo);
    }

    static Invoice transferToInvoice(Orders order, String memerNo, String title, Seller seller){
        Invoice invoice = new Invoice();
        invoice.setInvoiceNo("INV"+NFruitsUtils.identifier());
        invoice.setGoodsNo(order.getGoodsNo());
        invoice.setCreateTime(NFruitsUtils.getCurrentTime());
        invoice.setUpdateTime(invoice.getCreateTime());
        invoice.setMemberNo(memerNo);
        invoice.setAmount(order.getGoodsNumber());
        invoice.setTitle(title);
        invoice.setSellerNo(seller.getSellerNo());
        invoice.setStatus(0);
        invoice.setRemark(order.getRemark());
        invoice.setSendAddress(seller.getSendAddress());
        invoice.setReceiveAddress(order.getReceivAddress());
        invoice.setReceiveName(order.getReceiveName());
        invoice.setPhone(order.getPhone());
        invoice.setOrderNo(order.getOrderNo());
        return invoice;
    }
}
