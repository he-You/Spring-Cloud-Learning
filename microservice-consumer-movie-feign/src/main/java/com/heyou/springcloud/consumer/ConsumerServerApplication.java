package com.heyou.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/2 23:16
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
