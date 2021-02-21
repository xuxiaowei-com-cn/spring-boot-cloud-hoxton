package cn.com.xuxiaowei.cloud.ui.test.service.impl;

import cn.com.xuxiaowei.cloud.ui.test.entity.TestPassportI;
import cn.com.xuxiaowei.cloud.ui.test.hystrix.TestIHystrixService;
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
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class TestServiceImpl implements ITestService {

    private TestIHystrixService testIHystrixService;

    private TestPassportHystrixService testPassportHystrixService;

    @Autowired
    public void setTestIHystrixService(TestIHystrixService testIHystrixService) {
        this.testIHystrixService = testIHystrixService;
    }

    @Autowired
    public void setTestPassportHystrixService(TestPassportHystrixService testPassportHystrixService) {
        this.testPassportHystrixService = testPassportHystrixService;
    }

    /**
     * 测试 分布式事务 seata
     *
     * @param testPassportI 测试表
     * @return 返回 分布式事务 seata 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> seataSave(TestPassportI testPassportI) {

        log.info("当前 XID: {}", RootContext.getXID());

        Map<String, Object> map = new HashMap<>(4);

        Map<String, Object> saveI = testIHystrixService.save(testPassportI);
        Map<String, Object> savePassport = testPassportHystrixService.save(testPassportI);

        map.put("code", "00000");
        map.put("msg", "保存成功");

        map.put("saveI", saveI);
        map.put("savePassport", savePassport);

        return map;
    }

}
