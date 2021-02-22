package cn.com.xuxiaowei.cloud.oauth2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器 配置
 *
 * @author xuxiaowei
 * @see <a href="http://127.0.0.1:10301/sns/userinfo?access_token=">访问资源</a>
 * @see <a href="http://localhost:10301/sns/userinfo?access_token=">访问资源</a>
 * @since 0.0.1
 */
@Configuration
public class ResourceServerConfigurerAdapterConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 社交资源
        http.antMatcher("/sns/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/sns/userinfo")
                .access("#oauth2.hasAnyScope('snsapi_base','snsapi_userinfo')")
                .antMatchers(HttpMethod.POST, "/sns/userinfo")
                .access("#oauth2.hasAnyScope('snsapi_base','snsapi_userinfo')");

        // 需要放在最后
        super.configure(http);

    }

}
