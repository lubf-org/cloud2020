package cn.les.springcloud.dao;

import cn.les.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/11/16 10:58
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
