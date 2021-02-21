package cn.com.xuxiaowei.cloud.ui.test.hystrix;

import cn.com.xuxiaowei.cloud.ui.test.feign.TestPassportService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
