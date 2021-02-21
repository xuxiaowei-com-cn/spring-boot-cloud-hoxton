package cn.com.xuxiaowei.cloud.ui.test.hystrix;

import cn.com.xuxiaowei.cloud.ui.test.entity.TestPassportI;
import cn.com.xuxiaowei.cloud.ui.test.exception.TestPassportException;
import cn.com.xuxiaowei.cloud.ui.test.feign.TestPassportService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 测试 登录模块 Hystrix
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class TestPassportHystrixService {

    private TestPassportService testPassportService;

    @Autowired
    public void setTestPassportService(TestPassportService testPassportService) {
        this.testPassportService = testPassportService;
    }

    /**
     * 测试 登录模块 灰度发布
     *
     * @param gray 灰度发布
     * @return 返回 灰度发布
     */
    @HystrixCommand(fallbackMethod = "echoFallback")
    public String echo(String gray) {
        return testPassportService.echo(gray);
    }

    /**
     * 测试 登录模块 灰度发布
     *
     * @param gray 灰度发布
     * @return 返回 灰度发布
     */
    public String echoFallback(String gray) {
        return "登录模块 故障";
    }

    /**
     * 测试 登录模块 参数接收、保存数据 服务实现
     *
     * @param testPassportI 登录模块测试表，必填，否则调用失败
     * @return 返回 测试 登录模块 结果
     */
    @HystrixCommand(fallbackMethod = "saveFallback")
    public Map<String, Object> save(TestPassportI testPassportI) {
        return testPassportService.save(testPassportI);
    }

    /**
     * 测试 登录模块 参数接收、保存数据 异常数据
     *
     * @param testPassportI 登录模块测试表
     * @return 返回 异常 结果
     * @throws TestPassportException 测试登录模块 异常
     */
    public Map<String, Object> saveFallback(TestPassportI testPassportI) throws TestPassportException {
        throw new TestPassportException("A0001", "登录模块故障");
    }

}
