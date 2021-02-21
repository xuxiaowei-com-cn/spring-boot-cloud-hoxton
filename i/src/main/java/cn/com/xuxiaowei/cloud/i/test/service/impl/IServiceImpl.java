package cn.com.xuxiaowei.cloud.i.test.service.impl;

import cn.com.xuxiaowei.cloud.i.test.entity.I;
import cn.com.xuxiaowei.cloud.i.test.mapper.IMapper;
import cn.com.xuxiaowei.cloud.i.test.service.IIService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户模块测试表 服务实现类
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
@Service
public class IServiceImpl extends ServiceImpl<IMapper, I> implements IIService {

}
