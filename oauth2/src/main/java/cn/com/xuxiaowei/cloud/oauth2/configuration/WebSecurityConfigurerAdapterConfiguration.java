package cn.com.xuxiaowei.cloud.oauth2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Security 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class WebSecurityConfigurerAdapterConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * @see AuthorizationServerConfigurerAdapterConfiguration#setAuthenticationManager(AuthenticationManager)
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * @see AuthorizationServerConfigurerAdapterConfiguration#setUserDetailsService(UserDetailsService)
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

}
