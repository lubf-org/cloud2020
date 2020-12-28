package cn.les.springcloud.service;

import cn.les.springcloud.entities.CommonResult;
import cn.les.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/12/26 16:00
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));

    }
}
