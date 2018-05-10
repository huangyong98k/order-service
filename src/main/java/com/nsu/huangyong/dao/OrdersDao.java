package com.nsu.huangyong.dao;

import com.nsu.huangyong.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
public interface OrdersDao extends JpaRepository<Orders,Long> {
    List<Orders> findAllByMemberNo(String memberNo);
    Orders findOrdersByOrderNo(String orderNo);
    @Modifying
    @Query(value = "update orders set status = ?2 where  order_no = ?1",nativeQuery = true)
    void updateStatus(String orderNo, Integer status);
}
