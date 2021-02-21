package cn.com.xuxiaowei.cloud.ui.test.service;

import cn.com.xuxiaowei.cloud.ui.test.entity.TestPassportMe;

import java.util.Map;

/**
 * 测试接口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public interface ITestService {

    /**
     * 测试 分布式事务 seata
     *
     * @param testPassportMe 测试表
     * @return 返回 分布式事务 seata 结果
     */
    Map<String, Object> saveSeata(TestPassportMe testPassportMe);

}
