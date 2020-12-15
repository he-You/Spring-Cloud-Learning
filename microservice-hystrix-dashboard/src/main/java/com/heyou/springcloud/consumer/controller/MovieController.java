package com.heyou.springcloud.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/3 22:54
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
    @GetMapping("")
    public String index() {
        return "forward:/hystrix";
    }
}
