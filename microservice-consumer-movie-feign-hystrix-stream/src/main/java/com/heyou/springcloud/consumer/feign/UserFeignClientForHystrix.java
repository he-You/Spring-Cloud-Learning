package com.heyou.springcloud.consumer.feign;

import com.heyou.springcloud.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/12 22:35
 */
@FeignClient(name = "microservice-consumer-movie-feign", fallback = UserFeignClientForHystrixFallback.class)
public interface UserFeignClientForHystrix {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}


