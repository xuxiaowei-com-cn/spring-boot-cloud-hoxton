package cn.com.xuxiaowei.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务发现 程序执行入口
 * <p>
 * Spring Cloud 使用注解 {@link EnableEurekaServer} 的方式提供 Eureka 服务端
 *
 * @author xuxiaowei
 * @see <a href="https://docs.spring.io/spring-cloud-netflix/docs/2.2.6.RELEASE/reference/html/#spring-cloud-running-eureka-server">spring-cloud-running-eureka-server</a>
 * @since 0.0.1
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }

}
