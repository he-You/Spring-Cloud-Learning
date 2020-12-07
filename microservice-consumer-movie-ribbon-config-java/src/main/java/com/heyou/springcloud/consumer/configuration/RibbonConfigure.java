package com.heyou.springcloud.consumer.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon 配置类
 * 1.AvailabilityFilteringRule：过滤掉一直连接失败的被标记为circuit tripped的后端Server，并过滤掉那些高并发的后端Server或者使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个Server的运行状态；
 * 2.BestAvailableRule：选择一个最小的并发请求的Server，逐个考察Server，如果Server被tripped了，则跳过。
 * 3.RandomRule：随机选择一个Server；
 * 4.ResponseTimeWeightedRule：作用同WeightedResponseTimeRule，二者作用一样；
 * 5.RetryRule：对选定的负载均衡策略机上重试机制，在一个配置时间段内当选择Server不成功，则一直尝试使用subRule的方式选择一个可用的server；
 * 6.RoundRobinRule：轮询选择， 轮询index，选择index对应位置的Server；
 * 7.WeightedResponseTimeRule：根据响应时间加权，响应时间越长，权重越小，被选中的可能性越低；
 * 8.ZoneAvoidanceRule：复合判断Server所在区域的性能和Server的可用性选择Server；
 *
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/12/7 22:18
 */
@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfiguration.class)
public class RibbonConfigure {
}
