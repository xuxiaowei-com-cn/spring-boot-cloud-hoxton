package cn.com.xuxiaowei.cloud.ui.configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis Plus 配置
 * <p>
 * 扫描 Mapper 接口
 * <p>
 * 分页插件
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class MybatisPlusConfiguration {

    /**
     * 新的分页插件
     * <p>
     * 一缓和二缓遵循 MyBatis 的规则
     *
     * @return 返回 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
