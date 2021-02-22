package cn.com.xuxiaowei.cloud.passport.test.service;

import cn.com.xuxiaowei.cloud.passport.test.entity.PassportDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 登录模块测试表 服务类
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
public interface IPassportService extends IService<PassportDO> {

    /**
     * 保存-分布式事务
     *
     * @param entity 用户模块测试表
     * @return 返回 保存结果
     */
    boolean saveSeata(PassportDO entity);

}
