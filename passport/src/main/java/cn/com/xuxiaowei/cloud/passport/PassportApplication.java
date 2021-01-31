package cn.com.xuxiaowei.cloud.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 登录 程序执行入口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@EnableCaching
@EnableRedisHttpSession
@EnableWebSecurity
@EnableResourceServer
@EnableEurekaClient
@SpringBootApplication
public class PassportApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassportApplication.class, args);
    }

}
