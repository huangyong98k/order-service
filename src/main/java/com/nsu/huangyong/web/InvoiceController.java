package com.nsu.huangyong.web;

import com.nsu.huangyong.pojo.Invoice;
import com.nsu.huangyong.service.InvoiceService;
import com.nsu.huangyong.vo.CommonResp;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
@Slf4j
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @ApiOperation(value ="生成发货单" )
    @GetMapping("/add")
    public CommonResp add(@RequestParam("orderNo") String orderNo,
                          @RequestParam("memerNo") String memerNo,
                          @RequestParam("sellNo") String sellNo,
                          HttpServletRequest request){
        log.info("recevie msg:{}  {}  {}",orderNo,memerNo,sellNo);
        return invoiceService.initInvoice(orderNo,memerNo,sellNo);
    }
    @ApiOperation(value ="查询发货单" )
    @GetMapping("/find")
    public List<Invoice> find(@RequestParam("sellerNo") String sellerNo,
                              HttpServletRequest request){
        log.info("recevie msg:{}",sellerNo);
        return invoiceService.findListBySellerNo(sellerNo);
    }
    @ApiOperation(value ="发货" )
    @GetMapping("/service")
    public CommonResp service(@RequestParam("invoiceNo") String invoiceNo,
                          HttpServletRequest request){
        log.info("recevie invoiceNo:{}",invoiceNo);
        return invoiceService.service(invoiceNo);
    }
}
