package cn.com.xuxiaowei.cloud.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 断路器监控 程序执行入口
 * <p>
 * Spring Cloud 使用注解 {@link EnableEurekaClient} 的方式提供 Eureka 客户端（禁用 Eureka）
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
@EnableConfigurationProperties(AutoServiceRegistrationProperties.class)
public class MonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }

}
