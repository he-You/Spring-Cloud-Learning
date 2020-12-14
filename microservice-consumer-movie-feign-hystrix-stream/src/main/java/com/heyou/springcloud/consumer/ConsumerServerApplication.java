package com.heyou.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/2 23:16
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class, args);
    }
}
