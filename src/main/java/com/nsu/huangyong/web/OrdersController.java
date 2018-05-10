package com.nsu.huangyong.web;

import com.nsu.huangyong.model.OrdersReq;
import com.nsu.huangyong.pojo.Orders;
import com.nsu.huangyong.service.OrdersService;
import com.nsu.huangyong.vo.CommonResp;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @ApiOperation(value ="生成订单" )
    @PostMapping("/add")
    public CommonResp add(@RequestBody OrdersReq ordersReq,
                          HttpServletRequest request){
        log.info("recevie msg:{}",ordersReq.toString());
        return ordersService.addOrders(ordersReq);
    }
    @ApiOperation(value ="查询订单" )
    @GetMapping("/find")
    public List<Orders> find(@RequestParam("memberNo") String memberNo,
                     HttpServletRequest request){
        log.info("recevie msg:{}",memberNo);
        return ordersService.findOrdersByMemberNo(memberNo);
    }
    @ApiOperation(value ="更新订单状态" )
    @GetMapping("/upadte")
    public CommonResp upadte(@RequestParam("orderNo") String orderNo,
                             @RequestParam("status") Integer status,
                             HttpServletRequest request){
        log.info("recevie msg:{}",orderNo);
        return ordersService.updateStatus(orderNo,status);
    }
}
