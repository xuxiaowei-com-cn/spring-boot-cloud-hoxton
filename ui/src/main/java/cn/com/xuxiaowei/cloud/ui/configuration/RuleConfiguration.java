package cn.com.xuxiaowei.cloud.ui.configuration;

import cn.com.xuxiaowei.cloud.ui.ribbon.GrayLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class RuleConfiguration {

    @Bean
    public IRule grayLoadBalancerRule() {
        return new GrayLoadBalancerRule();
    }

}
