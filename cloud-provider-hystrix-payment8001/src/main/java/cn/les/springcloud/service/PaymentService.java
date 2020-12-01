package cn.les.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    //成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }

    //失败
    @HystrixCommand( fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds" , value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        //int a = 10 /0;
        int timeNumber = 5000;
        try {
            Thread.sleep(timeNumber);
            //TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"，程序超时或运行异常"+"========";
    }

}


