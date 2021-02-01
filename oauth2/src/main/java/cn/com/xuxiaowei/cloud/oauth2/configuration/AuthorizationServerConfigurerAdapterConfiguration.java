package cn.com.xuxiaowei.cloud.oauth2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * OAuth2 配置
 *
 * @author xuxiaowei
 * @see <a href="http://localhost:10601/oauth/authorize?client_id=xuxiaowei_client&redirect_uri=http://127.0.0.1:123&response_type=code&scope=snsapi_base&state=beff3dfc-bad8-40db-b25f-e5459e3d6ad7">获取 code</a>
 * @see <a href="http://localhost:10601/oauth/token?code=&client_id=xuxiaowei_client&client_secret=123&redirect_uri=http://127.0.0.1:123&grant_type=authorization_code">获取 Token</a>
 * @see <a href="http://127.0.0.1:10601/oauth/token?code=&client_id=xuxiaowei_client&client_secret=123&redirect_uri=http://127.0.0.1:123&grant_type=authorization_code">获取 Token</a>
 * @see <a href="http://localhost:10601/oauth/check_token?token=">检查 Token</a>
 * @see <a href="http://127.0.0.1:10601/oauth/check_token?token=">检查 Token</a>
 * @since 0.0.1
 */
@Configuration
public class AuthorizationServerConfigurerAdapterConfiguration extends AuthorizationServerConfigurerAdapter {

    /**
     * 数据源
     */
    private DataSource dataSource;

    /**
     * 认证管理器
     *
     * @see WebSecurityConfigurerAdapter 中的 authenticationManager()
     */
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        // 获取 Token 不需要权限，默认：不允许（Spring EL 表达式）
        security.tokenKeyAccess("permitAll()");

        // 检查 Token 不需要权限，默认：不允许（Spring EL 表达式）
        security.checkTokenAccess("permitAll()");

        // 允许 Client 进行表单验证，默认：不允许，否则将出现弹窗输入 ClientId、ClientSecret
        security.allowFormAuthenticationForClients();

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // 客户密码编辑器
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // 客户查询
        clients.jdbc(dataSource).passwordEncoder(delegatingPasswordEncoder);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // 获取 Token 可使用 GET、POST，默认：POST
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

        // 用户详细信息服务
        endpoints.userDetailsService(jdbcDaoImpl());

        // 认证管理器
        endpoints.authenticationManager(authenticationManager);

        // code 持久化
        endpoints.authorizationCodeServices(new JdbcAuthorizationCodeServices(dataSource));

        // Token 持久化
        endpoints.tokenStore(new JdbcTokenStore(dataSource));

    }

    /**
     * 刷新 Token 时查询用户
     */
    public JdbcDaoImpl jdbcDaoImpl() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
        return jdbcDao;
    }

}
