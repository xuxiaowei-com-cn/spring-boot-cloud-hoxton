package cn.com.xuxiaowei.cloud.ui.configuration;

import cn.com.xuxiaowei.cloud.ui.interceptor.FeignGrayRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class InterceptorConfiguration {

    @Bean
    public RequestInterceptor feignGrayRequestInterceptor() {
        return new FeignGrayRequestInterceptor();
    }

}
