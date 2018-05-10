package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.NFruitsUtils;
import com.nsu.huangyong.dao.InvoiceDao;
import com.nsu.huangyong.dao.LogisticsDao;
import com.nsu.huangyong.pojo.Invoice;
import com.nsu.huangyong.pojo.Logistics;
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
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    private LogisticsDao logisticsDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Override
    @Transactional
    public CommonResp initLogistics(String invoiceNo) {
        try {
            logisticsDao.save(transferToLogistics(invoiceDao.findInvoiceByInvoiceNo(invoiceNo)));
        } catch (Exception e) {
            log.error("error msg:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常！！！");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public List<Logistics> findLogisticsByMemberNo(String memberNo) {
        return logisticsDao.findLogisticsByMemberNo(memberNo);
    }

    @Override
    public CommonResp updateLogistics(String logisticsNo, String nowAddress) {
        try {
            logisticsDao.updateLogistics(nowAddress,0,logisticsNo);
        } catch (Exception e) {
            log.error("error msg:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常！！！");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    static Logistics transferToLogistics(Invoice invoice){
        Logistics logistics = new Logistics();
        logistics.setLogisticsNo("LOG"+ NFruitsUtils.identifier());
        logistics.setSendAddress(invoice.getSendAddress());
        logistics.setReceiveAddress(invoice.getReceiveAddress());
        logistics.setNowAddress(invoice.getSendAddress());
        logistics.setMemberNo(invoice.getMemberNo());
        logistics.setSellerNo(invoice.getSellerNo());
        logistics.setStatus(0);
        logistics.setCreateTime(NFruitsUtils.getCurrentTime());
        logistics.setUpdateTime(logistics.getCreateTime());
        logistics.setOrderNo(invoice.getOrderNo());
        logistics.setReceiveName(invoice.getReceiveName());
        logistics.setPhone(invoice.getPhone());
        return  logistics;
    }
}
