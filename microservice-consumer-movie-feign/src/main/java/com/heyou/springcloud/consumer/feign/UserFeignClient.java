package com.heyou.springcloud.consumer.feign;

import com.heyou.springcloud.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient 注解中的microservice-provider-user是想要请求服务的名称，
 * 这是用来创建Ribbon Client的（Feign整合了Ribbon）。
 * 在本例中，由于使用了Eureka，所以Ribbon会把microservice-provider-user 解析成Eureka Server中的服务。
 * 除此之外，还可使用url属性指定请求的URL（URL可以是完整的URL或主机名），
 * 例如@FeignClient(name = "abcde", url = "http://localhost:8000/") 。
 * 此时，name可以是任意值，但不可省略，否则应用将无法启动！
 *
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/10 22:21
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
