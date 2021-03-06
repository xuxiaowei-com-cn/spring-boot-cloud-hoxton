package cn.com.xuxiaowei.cloud.ui.interceptor;

import cn.com.xuxiaowei.cloud.ui.ribbon.RibbonRequestContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 灰度 Http请求拦截器 {@link RestTemplate}
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class RestTemplateGrayClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    /**
     * 用于请求时获取 header 并放入到线程中
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        String gray = "gray";
        if (headers.containsKey(gray)) {
            String grayValue = headers.getFirst(gray);
            if (Boolean.TRUE.toString().equals(grayValue)) {
                RibbonRequestContextHolder.getCurrentContext().put(gray, Boolean.TRUE.toString());
            }
        }
        return execution.execute(request, body);
    }

}
