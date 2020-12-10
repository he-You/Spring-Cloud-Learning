package com.heyou.springcloud.consumer.controller;

import com.heyou.springcloud.consumer.entity.User;
import com.heyou.springcloud.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/3 22:54
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
//        User user = this.restTemplate.getForObject(
//                "http://microservice-provider-user/users/{id}",
//                User.class,
//                id
//        );

        return this.userFeignClient.findById(id);
    }
}
