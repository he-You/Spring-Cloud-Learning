package com.heyou.springcloud.consumer.controller;

import com.heyou.springcloud.consumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/3 22:54
 */
@RequestMapping("/movies")
@RestController
@Slf4j
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand 注解，就可保护该API。
     * 这里的”保护“，其实带有三层含义——”超时机制“、”仓壁模式“、”断路器“！
     * fallbackMethod 属性，指定了一个降级方法，如不指定，Hystrix会有一个默认的降级方案，那就是抛异常
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        User user = this.restTemplate.getForObject(
                "http://microservice-provider-user/users/{id}",
                User.class,
                id
        );
        // ...电影微服务的业务...
        return user;
    }

    public User findByIdFallback(Long id, Throwable throwable) {
        log.error("进入回退方法", throwable);
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
