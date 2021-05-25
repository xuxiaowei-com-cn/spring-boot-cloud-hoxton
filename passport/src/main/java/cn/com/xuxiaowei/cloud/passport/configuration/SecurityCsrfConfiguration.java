//package cn.com.xuxiaowei.cloud.passport.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.LazyCsrfTokenRepository;
//
///**
// * Security CSRF 跨站请求伪造 配置
// *
// * @author xuxiaowei
// * @since 0.0.1
// */
//@Configuration
//public class SecurityCsrfConfiguration {
//
//    /**
//     * Security Cookie CSRF 跨站请求伪造 配置
//     * <p>
//     * 默认为懒加载 {@link LazyCsrfTokenRepository}
//     *
//     * @return 返回可使用 {@link Autowired} Security Cookie CSRF 跨站请求伪造
//     * @see CsrfFilter
//     */
//    @Bean
//    public CookieCsrfTokenRepository cookieCsrfTokenRepository() {
//        return new CookieCsrfTokenRepository();
//    }
//
//}
