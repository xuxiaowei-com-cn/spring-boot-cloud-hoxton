package cn.com.xuxiaowei.cloud.passport.test.service.impl;

import cn.com.xuxiaowei.cloud.passport.test.dto.PassportDTO;
import cn.com.xuxiaowei.cloud.passport.test.entity.PassportDO;
import cn.com.xuxiaowei.cloud.passport.test.mapper.PassportMapper;
import cn.com.xuxiaowei.cloud.passport.test.service.IPassportService;
import cn.com.xuxiaowei.cloud.passport.test.vo.PassportVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
     * @param passportDTO 用户模块测试表
     * @return 返回 保存结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public PassportVO saveSeata(PassportDTO passportDTO) {

        log.info("当前 XID: {}", RootContext.getXID());

        PassportDO passportDO = new PassportDO();
        BeanUtils.copyProperties(passportDTO, passportDO);

        save(passportDO);

        int i = 1 / passportDTO.getPassportNum();

        PassportVO passportVO = new PassportVO();
        BeanUtils.copyProperties(passportDO, passportVO);

        return passportVO;
    }

}
