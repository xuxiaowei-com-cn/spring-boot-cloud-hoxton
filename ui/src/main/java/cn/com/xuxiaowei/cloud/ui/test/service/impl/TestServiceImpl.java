package cn.com.xuxiaowei.cloud.ui.test.service.impl;

import cn.com.xuxiaowei.cloud.ui.test.dto.TestPassportMeDTO;
import cn.com.xuxiaowei.cloud.ui.test.hystrix.TestMeHystrixService;
import cn.com.xuxiaowei.cloud.ui.test.hystrix.TestPassportHystrixService;
import cn.com.xuxiaowei.cloud.ui.test.service.ITestService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试接口 实现类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class TestServiceImpl implements ITestService {

    private TestMeHystrixService testMeHystrixService;

    private TestPassportHystrixService testPassportHystrixService;

    @Autowired
    public void setTestMeHystrixService(TestMeHystrixService testMeHystrixService) {
        this.testMeHystrixService = testMeHystrixService;
    }

    @Autowired
    public void setTestPassportHystrixService(TestPassportHystrixService testPassportHystrixService) {
        this.testPassportHystrixService = testPassportHystrixService;
    }

    /**
     * 测试 分布式事务 seata
     *
     * @param testPassportMeDTO 测试表
     * @return 返回 分布式事务 seata 结果
     */
    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> saveSeata(TestPassportMeDTO testPassportMeDTO) {

        log.info("当前 XID: {}", RootContext.getXID());

        Map<String, Object> map = new HashMap<>(4);

        Map<String, Object> saveMe = testMeHystrixService.save(testPassportMeDTO);
        Map<String, Object> savePassport = testPassportHystrixService.save(testPassportMeDTO);

        map.put("code", "00000");
        map.put("msg", "保存成功");

        map.put("saveMe", saveMe);
        map.put("savePassport", savePassport);

        return map;
    }

}
