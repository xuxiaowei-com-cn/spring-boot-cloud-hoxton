package cn.com.xuxiaowei.cloud.passport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 登录模块 程序执行入口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
//@EnableCaching
//@EnableRedisHttpSession
//@EnableWebSecurity
//@EnableResourceServer
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan("cn.com.xuxiaowei.cloud.*.servlet")
@MapperScan("cn.com.xuxiaowei.cloud.*.*.mapper.**")
public class PassportApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassportApplication.class, args);
    }

}
