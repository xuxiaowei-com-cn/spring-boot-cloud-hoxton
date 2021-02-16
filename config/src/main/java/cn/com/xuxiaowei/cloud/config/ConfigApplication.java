package cn.com.xuxiaowei.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.encryption.EncryptionController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置 程序执行入口
 * <p>
 * Spring Cloud 使用注解 {@link EnableEurekaClient} 的方式提供 Eureka 客户端
 * Spring Cloud 使用注解 {@link EnableConfigServer} 的方式提供 开启配置服务器
 * Spring Cloud 使用注解 {@link EnableConfigurationProperties#value()} 设置 {@link AutoServiceRegistrationProperties} 的方式提供 Nacos 客户端
 *
 * @author xuxiaowei
 * @see EncryptionController
 * @since 0.0.1
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
@EnableConfigurationProperties(AutoServiceRegistrationProperties.class)
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
