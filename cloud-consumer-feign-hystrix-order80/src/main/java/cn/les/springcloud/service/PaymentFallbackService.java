package cn.les.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/12/3 9:16
 */
@Component  //注意：一定要加Component
public class PaymentFallbackService implements  PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
