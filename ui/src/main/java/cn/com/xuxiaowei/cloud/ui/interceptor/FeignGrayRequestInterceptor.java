package cn.com.xuxiaowei.cloud.ui.interceptor;

import cn.com.xuxiaowei.cloud.ui.ribbon.RibbonRequestContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 灰度 请求拦截器 {@link FeignClient}
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class FeignGrayRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        Map<String, Collection<String>> headers = template.headers();
        String gray = "gray";
        if (headers.containsKey(gray)) {
            Collection<String> grayValues = headers.get(gray);
            Iterator<String> grayValuesIterator = grayValues.iterator();
            String grayValue = grayValuesIterator.next();
            if (Boolean.TRUE.toString().equals(grayValue)) {
                RibbonRequestContextHolder.getCurrentContext().put(gray, Boolean.TRUE.toString());
            }
        }
    }

}
