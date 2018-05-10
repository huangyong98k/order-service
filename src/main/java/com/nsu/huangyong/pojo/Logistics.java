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
public class Logistics {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;//
    private String logisticsNo;
    private String sendAddress;
    private String receiveAddress;
    private String nowAddress;
    private String memberNo;
    private String sellerNo;
    private Integer status;
    private String createTime;
    private String updateTime;
    private String orderNo;
    private String receiveName;
    private String phone;

}
