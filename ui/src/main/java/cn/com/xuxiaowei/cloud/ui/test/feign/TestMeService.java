package cn.com.xuxiaowei.cloud.ui.test.feign;

import cn.com.xuxiaowei.cloud.ui.interceptor.HeadersRequestInterceptor;
import cn.com.xuxiaowei.cloud.ui.test.dto.TestPassportMeDTO;
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
@FeignClient(value = "me", contextId = "testMeService", configuration = HeadersRequestInterceptor.class)
public interface TestMeService {

    /**
     * 测试 用户模块 参数接收、保存数据
     *
     * @param testPassportMeDTO 用户模块测试表，必填，否则调用失败
     * @return 返回 用户模块 测试结果
     */
    @PostMapping("/test/me/save")
    Map<String, Object> save(@RequestBody TestPassportMeDTO testPassportMeDTO);

}
