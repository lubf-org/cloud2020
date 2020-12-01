package cn.les.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/11/17 9:21
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8006.class);
    }
}
