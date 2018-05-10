package com.nsu.huangyong.service;

import com.nsu.huangyong.pojo.Invoice;
import com.nsu.huangyong.vo.CommonResp;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
public interface InvoiceService {
    /**
     * 生成发货单
     */
    CommonResp initInvoice(String orderNo, String memerNo, String sellNo);
    /**
     * 查看发货单
     */
    List<Invoice> findListBySellerNo(String sellerNo);
    /**
     * 发货
     */
    CommonResp service(String invoiceNo);
}
