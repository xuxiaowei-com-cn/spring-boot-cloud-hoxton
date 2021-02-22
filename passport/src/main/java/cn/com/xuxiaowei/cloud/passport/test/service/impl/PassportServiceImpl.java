package cn.com.xuxiaowei.cloud.passport.test.service.impl;

import cn.com.xuxiaowei.cloud.passport.test.entity.PassportDO;
import cn.com.xuxiaowei.cloud.passport.test.mapper.PassportMapper;
import cn.com.xuxiaowei.cloud.passport.test.service.IPassportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 登录模块测试表 服务实现类
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
@Slf4j
@Service
public class PassportServiceImpl extends ServiceImpl<PassportMapper, PassportDO> implements IPassportService {

    /**
     * 保存-分布式事务
     *
     * @param entity 用户模块测试表
     * @return 返回 保存结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean saveSeata(PassportDO entity) {

        log.info("当前 XID: {}", RootContext.getXID());

        boolean save = save(entity);

        int i = 1 / entity.getPassportNum();

        return save;
    }

}
