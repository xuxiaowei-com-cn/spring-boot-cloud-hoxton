//package cn.com.xuxiaowei.cloud.me.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
//
///**
// * 资源服务器 配置
// *
// * @author xuxiaowei
// * @since 0.0.1
// */
//@Configuration
//public class ResourceServerConfigurerAdapterConfiguration extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry
//                = http.antMatcher("/**").authorizeRequests();
//
//        // 测试路径 不需要 Token
//        AntPathRequestMatcher testAnt = new AntPathRequestMatcher("/test/**");
//        expressionInterceptUrlRegistry.requestMatchers(testAnt).permitAll();
//
//        // 排除 测试路径 需要 Token
//        NegatedRequestMatcher testNegated = new NegatedRequestMatcher(testAnt);
//
//        // 其他路径 需要 Token
//        expressionInterceptUrlRegistry.requestMatchers(testNegated).authenticated();
//
//    }
//
//}
