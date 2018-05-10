package com.nsu.huangyong.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Huang-Yong on 2018/5/7
 */
@Data
@Entity
public class Invoice {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;
    private String invoiceNo;
    private String goodsNo;
    private String orderNo;
    private String memberNo;
    private String amount;
    private String title;
    private String sellerNo;
    private Integer status;
    private String createTime;
    private String updateTime;
    private String remark;
    private String sendAddress;
    private String receiveAddress;
    private String receiveName;
    private String phone;
}
