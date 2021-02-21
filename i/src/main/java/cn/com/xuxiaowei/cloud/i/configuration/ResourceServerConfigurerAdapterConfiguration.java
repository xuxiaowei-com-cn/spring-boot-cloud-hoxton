package cn.com.xuxiaowei.cloud.i.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

/**
 * 资源服务器 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class ResourceServerConfigurerAdapterConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry
                = http.antMatcher("/**").authorizeRequests();

        // 用户模块 测试路径 不需要 Token
        AntPathRequestMatcher testIAnt = new AntPathRequestMatcher("/test/i/**");
        expressionInterceptUrlRegistry.requestMatchers(testIAnt).permitAll();

        // 排除 用户模块 测试路径 需要 Token
        NegatedRequestMatcher testINegated = new NegatedRequestMatcher(testIAnt);

        // 其他路径 需要 Token
        expressionInterceptUrlRegistry.requestMatchers(testINegated).authenticated();

    }

}
