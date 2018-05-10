package com.nsu.huangyong.model;

import lombok.Data;

/**
 * Created by Huang-Yong on 2018/5/7
 */
@Data
public class OrdersReq {
    private String memberNo;
    private String distributionWay;
    private String invoiceType;
    private String invoiceTitle;
    private String invoiceContent;
    private String goodsNo;
    private String goodsNumber;
    private String freight;
    private String totalNum;
    private String receivAddress;
    private String receivName;
    private String phone;
    private String remark;
}
