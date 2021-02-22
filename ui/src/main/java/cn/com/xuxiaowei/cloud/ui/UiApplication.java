package cn.com.xuxiaowei.cloud.ui;

import cn.com.xuxiaowei.cloud.ui.ribbon.GrayLoadBalancerRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * UI(Ribbon、Feign)(界面模块) 程序执行入口
 * <p>
 * 通过 {@link EnableFeignClients} 开启 feign 客户端支持
 * 通过 {@link EnableResourceServer} 开启资源保护
 * 通过 {@link EnableFeignClients} 开启 feign 客户端支持
 * 通过 {@link EnableCircuitBreaker} 开启 CircuitBreaker 的支持。使服务能够使用 Hystrix 和 Ribbon 库。
 * 通过 {@link RibbonClients#defaultConfiguration()} 开启默认服务的负载均衡路由配置
 * 通过 {@link RibbonClients#value()} 开启指定服务的负载均衡路由配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@EnableCaching
@EnableRedisHttpSession
@EnableFeignClients
@EnableWebSecurity
@EnableResourceServer
@EnableCircuitBreaker
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan("cn.com.xuxiaowei.cloud.*.servlet")
@MapperScan("cn.com.xuxiaowei.cloud.*.*.mapper.**")
@RibbonClients(defaultConfiguration = {GrayLoadBalancerRule.class})
public class UiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }

}
