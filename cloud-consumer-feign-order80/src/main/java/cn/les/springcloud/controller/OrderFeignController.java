package cn.les.springcloud.controller;

import cn.les.springcloud.entities.CommonResult;
import cn.les.springcloud.entities.Payment;
import cn.les.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/11/24 15:22
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService  paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        String str = paymentFeignService.paymentFeignTimeout();
        return str;
    }


}
