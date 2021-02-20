package cn.com.xuxiaowei.cloud.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;
import java.util.Map;

/**
 * OAuth2 服务 程序执行入口
 * <p>
 * Spring Cloud 使用注解 {@link EnableEurekaClient} 的方式提供 Eureka 客户端（禁用 Eureka）
 * Spring Cloud 使用注解 {@link EnableConfigurationProperties#value()} 设置 {@link AutoServiceRegistrationProperties} 的方式提供 Nacos 客户端
 *
 * @author xuxiaowei
 * @see AuthorizationEndpoint#authorize(Map, Map, SessionStatus, Principal) 多权限使用空格分隔
 * @see TokenEndpoint#getAccessToken(Principal, Map)
 * @see TokenEndpoint#postAccessToken(Principal, Map)
 * @see CheckTokenEndpoint#checkToken(String)
 * @see BaseClientDetails#BaseClientDetails(String, String, String, String, String, String) 若 authorizedGrantTypes 为空，
 * 程序自动设置默认值："authorization_code", "refresh_token"
 * @see BaseClientDetails#isAutoApprove(String) 自动授权
 * @since 0.0.1
 */
@EnableCaching
@EnableRedisHttpSession
@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.com.xuxiaowei.cloud.oauth2.*.mapper.**")
@EnableConfigurationProperties(AutoServiceRegistrationProperties.class)
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}
