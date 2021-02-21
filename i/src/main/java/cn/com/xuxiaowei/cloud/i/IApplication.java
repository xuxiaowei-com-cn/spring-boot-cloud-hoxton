package cn.com.xuxiaowei.cloud.i;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 用户模块 程序执行入口
 * <p>
 * Spring Cloud 使用注解 {@link EnableEurekaClient} 的方式提供 Eureka 客户端（禁用 Eureka）
 * Spring Cloud 使用注解 {@link EnableConfigurationProperties#value()} 设置 {@link AutoServiceRegistrationProperties} 的方式提供 Nacos 客户端
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@EnableCaching
@EnableRedisHttpSession
@EnableWebSecurity
@EnableResourceServer
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan("cn.com.xuxiaowei.cloud.i.servlet")
@MapperScan("cn.com.xuxiaowei.cloud.i.*.mapper.**")
@EnableConfigurationProperties(AutoServiceRegistrationProperties.class)
public class IApplication {

    public static void main(String[] args) {
        SpringApplication.run(IApplication.class, args);
    }

}
