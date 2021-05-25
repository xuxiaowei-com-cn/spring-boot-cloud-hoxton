package cn.com.xuxiaowei.cloud.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 用户模块 程序执行入口
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
public class MeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeApplication.class, args);
    }

}
