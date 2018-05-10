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
public class Orders {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;//
    private String orderNo;//订单编号
    private String createTime;//
    private String payTime;//
    private String memberNo;//
    private String distributionWay;//
    private String invoiceType;//
    private String invoiceTitle;//
    private String invoiceContent;//
    private String goodsNo;//
    private String goodsNumber;//
    private String freight;//
    private String totalNum;//
    private String receivAddress;//
    private String receiveName;//
    private String phone;//
    private String remark;
    private String channel;//
    private Integer status;//

}
