package com.heyou.springcloud.consumer.feign;

import com.heyou.springcloud.consumer.entity.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/12 22:41
 */
@Component
public class UserFeignClientForHystrixFallback implements UserFeignClientForHystrix {
    @Override
    public User findById(Long id) {
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
