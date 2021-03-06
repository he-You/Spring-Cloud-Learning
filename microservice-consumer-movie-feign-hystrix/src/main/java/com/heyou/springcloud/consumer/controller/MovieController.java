package com.heyou.springcloud.consumer.controller;

import com.heyou.springcloud.consumer.entity.User;
import com.heyou.springcloud.consumer.feign.UserFeignClientForHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/3 22:54
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
    @Qualifier("microservice-provider-user-feign")
    @Autowired
    public UserFeignClientForHystrix userFeignClientForHystrix;
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClientForHystrix.findById(id);
    }
}
