package cn.com.xuxiaowei.cloud.ui.test.hystrix;

import cn.com.xuxiaowei.cloud.ui.test.dto.TestPassportMeDTO;
import cn.com.xuxiaowei.cloud.ui.test.exception.TestMeException;
import cn.com.xuxiaowei.cloud.ui.test.feign.TestMeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 测试 用户模块 Hystrix
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class TestMeHystrixService {

    private TestMeService testMeService;

    @Autowired
    public void setTestMeService(TestMeService testMeService) {
        this.testMeService = testMeService;
    }

    /**
     * 测试 用户模块 参数接收、保存数据 服务实现
     *
     * @param testPassportMeDTO 用户模块测试表，必填，否则调用失败
     * @return 返回 测试 用户模块 结果
     */
    @HystrixCommand(fallbackMethod = "saveFallback")
    public Map<String, Object> save(TestPassportMeDTO testPassportMeDTO) {
        return testMeService.save(testPassportMeDTO);
    }

    /**
     * 测试 用户模块 参数接收、保存数据 异常数据
     *
     * @param testPassportMeDTO 用户模块测试表
     * @return 返回 异常 结果
     * @throws TestMeException 测试用户模块 异常
     */
    public Map<String, Object> saveFallback(TestPassportMeDTO testPassportMeDTO) throws TestMeException {
        throw new TestMeException("A0002", "用户模块故障");
    }

}
