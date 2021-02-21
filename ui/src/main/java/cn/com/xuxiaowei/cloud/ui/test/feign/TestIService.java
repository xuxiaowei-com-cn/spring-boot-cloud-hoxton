package cn.com.xuxiaowei.cloud.ui.test.feign;

import cn.com.xuxiaowei.cloud.ui.interceptor.HeadersRequestInterceptor;
import cn.com.xuxiaowei.cloud.ui.test.entity.TestPassportI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 测试 用户模块 接口
 *
 * @author xuxiaowei
 * @see FeignClient#contextId() 防止出现相同的 {@link FeignClient#value()} 时异常
 * @since 0.0.1
 */
@FeignClient(value = "i", contextId = "testIService", configuration = HeadersRequestInterceptor.class)
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public interface TestIService {

    /**
     * 测试 用户模块 参数接收、保存数据
     *
     * @param testPassportI 用户模块测试表，必填，否则调用失败
     * @return 返回 用户模块 测试结果
     */
    @PostMapping("/test/i/save")
    Map<String, Object> save(@RequestBody TestPassportI testPassportI);

}
