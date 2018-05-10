package com.nsu.huangyong.web;


import com.nsu.huangyong.pojo.Logistics;
import com.nsu.huangyong.service.LogisticsService;
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
@RequestMapping("/logistics")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;
    @ApiOperation(value ="查询物流信息" )
    @GetMapping("/find")
    public List<Logistics> find(@RequestParam("memberNo") String memberNo,
                                HttpServletRequest request){
        log.info("recevie msg:{}",memberNo);
        return logisticsService.findLogisticsByMemberNo(memberNo);
    }
    @ApiOperation(value ="更新物流信息" )
    @GetMapping("/update")
    public CommonResp update(@RequestParam("logisticsNo") String logisticsNo,
                           @RequestParam("logisticsNo") String nowAddress,
                           HttpServletRequest request){
        log.info("recevie msg:{}  {}",logisticsNo,nowAddress);
        return logisticsService.updateLogistics(logisticsNo,nowAddress);
    }
}
