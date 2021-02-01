package cn.com.xuxiaowei.cloud.passport.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * 资源服务器 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class ResourceServerConfigurerAdapterConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * Security CORS 跨域资源共享 配置
     */
    private CorsConfigurationSource corsConfigurationSource;

    @Autowired
    public void setCorsConfigurationSource(@Qualifier("urlBasedCorsConfigurationSource")
                                                   CorsConfigurationSource corsConfigurationSource) {
        this.corsConfigurationSource = corsConfigurationSource;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry
                = http.antMatcher("/**").authorizeRequests();

        // 登录请求（POST）不需要Token
        AntPathRequestMatcher loginAnt = new AntPathRequestMatcher("/login", HttpMethod.POST.toString());
        // 登录成功 不需要Token
        AntPathRequestMatcher loginSuccessAnt = new AntPathRequestMatcher("/login/success");
        // 登录失败 不需要Token
        AntPathRequestMatcher loginFailureAnt = new AntPathRequestMatcher("/login/failure");
        expressionInterceptUrlRegistry.requestMatchers(loginAnt, loginSuccessAnt, loginFailureAnt).permitAll();

        // 排除 登录请求（POST）的地址 需要Token
        NegatedRequestMatcher loginNegated = new NegatedRequestMatcher(loginAnt);
        // 排除 登录成功的地址 需要Token
        NegatedRequestMatcher loginSuccessNegated = new NegatedRequestMatcher(loginSuccessAnt);
        // 排除 登录失败的地址 需要Token
        NegatedRequestMatcher loginFailureNegated = new NegatedRequestMatcher(loginFailureAnt);
        // 其他路径 需要Token
        expressionInterceptUrlRegistry.requestMatchers(loginNegated, loginSuccessNegated, loginFailureNegated)
                .authenticated();

        // 添加一个地址及权限（由于优先级的问题，至少存在一个此配置，才能正常配置 Security，否则 Security 无效）
        http.antMatcher("/test-scope/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/test-scope/1")
                .access("#oauth2.hasAnyScope('test-scope_1')");

        // Security CORS 跨域配置
        http.cors().configurationSource(corsConfigurationSource);

    }

}
