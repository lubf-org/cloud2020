package cn.les.springcloud.service.impl;

import cn.les.springcloud.dao.PaymentDao;
import cn.les.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import cn.les.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-18 10:40
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
