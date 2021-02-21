package cn.com.xuxiaowei.cloud.ui.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 配置 负载均衡 {@link RestTemplate}
 *
 * @author xuxiaowei
 * @see LoadBalanced 负载均衡
 * @since 0.0.1
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new RestTemplateGrayInterceptor());
        return restTemplate;
    }

}
