package com.nsu.huangyong.dao;

import com.nsu.huangyong.pojo.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/5/7
 */
public interface InvoiceDao extends JpaRepository<Invoice,Long> {
    List<Invoice> findAllByMemberNo(String memberNo);
    List<Invoice> findAllBySellerNo(String sellerNo);

    Invoice findInvoiceByInvoiceNo(String invoiceNo);

    List<Invoice> findAllByMemberNoAndStatus(String memberNo,Integer status);
    List<Invoice> findAllBySellerNoAndStatus(String sellerNo,Integer status);

    @Modifying
    @Query(value = "update invoice set status = ?2 where invoice_no = ?1",nativeQuery = true)
    void updateStatus(String invoiceNo,Integer status);
}
