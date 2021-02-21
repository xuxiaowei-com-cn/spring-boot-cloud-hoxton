package cn.com.xuxiaowei.cloud.me.test.service.impl;

import cn.com.xuxiaowei.cloud.me.test.entity.Me;
import cn.com.xuxiaowei.cloud.me.test.mapper.MeMapper;
import cn.com.xuxiaowei.cloud.me.test.service.IMeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户模块测试表 服务实现类
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
@Slf4j
@Service
public class MeServiceImpl extends ServiceImpl<MeMapper, Me> implements IMeService {

    /**
     * 保存-分布式事务
     *
     * @param entity 用户模块测试表
     * @return 返回 保存结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean saveSeata(Me entity) {

        log.info("当前 XID: {}", RootContext.getXID());

        boolean save = save(entity);

        int i = 1 / entity.getMeNum();

        return save;
    }

}
