package cn.com.xuxiaowei.cloud.passport.configuration;

import cn.com.xuxiaowei.cloud.passport.filter.CsrfCookieBeforeOncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;

/**
 * WebSecurity 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class WebSecurityConfigurerAdapterConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 数据源
     */
    private DataSource dataSource;

    /**
     * Security CSRF 跨站请求伪造 配置
     */
    private CsrfTokenRepository csrfTokenRepository;

    /**
     * Security CORS 跨域资源共享 配置
     */
    private CorsConfigurationSource corsConfigurationSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setCsrfTokenRepository(CsrfTokenRepository csrfTokenRepository) {
        this.csrfTokenRepository = csrfTokenRepository;
    }

    @Autowired
    public void setCorsConfigurationSource(@Qualifier("urlBasedCorsConfigurationSource")
                                                   CorsConfigurationSource corsConfigurationSource) {
        this.corsConfigurationSource = corsConfigurationSource;
    }

    /**
     * 认证管理器
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * 用户详细信息服务
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    /**
     * @see super#configure(HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Form Login 配置
        http.formLogin()
                // 登录页面
                .loginPage("/login")
                // 登录请求
                .loginProcessingUrl("/login")
                // 登录成功
                .successForwardUrl("/login/success")
                // 登录失败
                .failureForwardUrl("/login/failure")
                .permitAll()
        ;

        // 权限配置
        http.authorizeRequests().anyRequest().authenticated();

        // Security CSRF 跨站请求伪造 配置
        http.csrf().csrfTokenRepository(csrfTokenRepository);
        http.addFilterBefore(new CsrfCookieBeforeOncePerRequestFilter(csrfTokenRepository), CsrfFilter.class);

        // Security CORS 跨域资源共享 配置
        http.cors().configurationSource(corsConfigurationSource);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 用户密码编辑器
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // 查询登录用户
        auth.userDetailsService(jdbcDaoImpl()).passwordEncoder(delegatingPasswordEncoder);

    }

    /**
     * 登录时查询用户
     */
    public JdbcDaoImpl jdbcDaoImpl() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
        return jdbcDao;
    }

}
