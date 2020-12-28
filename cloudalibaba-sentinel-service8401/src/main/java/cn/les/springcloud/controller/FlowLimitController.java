package cn.les.springcloud.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.les.springcloud.entities.CommonResult;
import cn.les.springcloud.entities.Payment;
import cn.les.springcloud.mybandler.CustomerBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/12/23 15:59
 */
@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA()  throws  Exception{
        Thread.sleep(800);
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(Thread.currentThread().getName()+"===========testB");
        return "------testB";
    }


    //------------降级熔断测试--------
    @GetMapping("/testD")
    public String testD() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
        }

        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
       int d =  1/0;

        return "------testD";
    }


    @GetMapping("/testF")
    public String testF() {
       throw  new RuntimeException("erssor");

        //return "------testD";
    }

    //-----------------------热点key-------------------------------
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey",fallback = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }



    //---------------------------------SentinelResource----------------------------------------
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }



    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException")
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }


}

