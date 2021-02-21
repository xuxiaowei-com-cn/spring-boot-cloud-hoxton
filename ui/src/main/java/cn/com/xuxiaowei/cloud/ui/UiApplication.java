package cn.com.xuxiaowei.cloud.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * UI(Ribbon、Feign)(界面模块) 程序执行入口
 * <p>
 * 通过 {@link EnableFeignClients} 开启 feign 客户端支持
 * Spring Cloud 使用注解 {@link EnableEurekaClient} 的方式提供 Eureka 客户端（禁用 Eureka）
 * Spring Cloud 使用注解 {@link EnableConfigurationProperties#value()} 设置 {@link AutoServiceRegistrationProperties} 的方式提供 Nacos 客户端
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@EnableCaching
@EnableRedisHttpSession
@EnableFeignClients
@SpringBootApplication
@ServletComponentScan("cn.com.xuxiaowei.cloud.*.servlet")
@MapperScan("cn.com.xuxiaowei.cloud.*.*.mapper.**")
@EnableConfigurationProperties(AutoServiceRegistrationProperties.class)
public class UiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }

}
