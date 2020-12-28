package com.heyou.springcloud.sleuth.controller;


import com.heyou.springcloud.sleuth.dao.UserRepository;
import com.heyou.springcloud.sleuth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/11/30 23:28
 */
@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        System.out.println("这是生产者服务-a");
        return this.userRepository.findById(id);
    }
}
