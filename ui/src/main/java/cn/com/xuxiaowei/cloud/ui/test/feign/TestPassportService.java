package cn.com.xuxiaowei.cloud.ui.test.feign;

import cn.com.xuxiaowei.cloud.ui.interceptor.HeadersRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 测试 登录模块 接口
 *
 * @author xuxiaowei
 * @see FeignClient#contextId() 防止出现相同的 {@link FeignClient#value()} 时异常
 * @since 0.0.1
 */
@FeignClient(value = "passport", contextId = "testPassportService", configuration = HeadersRequestInterceptor.class)
public interface TestPassportService {

    /**
     * 测试 登录模块 灰度发布
     *
     * @param gray 灰度发布
     * @return 返回 灰度发布
     */
    @GetMapping("/test/echo")
    String echo(@RequestHeader("gray") String gray);

}
