//package cn.com.xuxiaowei.cloud.passport.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
///**
// * Security CORS 跨域资源共享 配置
// *
// * @author xuxiaowei
// * @since 0.0.1
// */
//@Configuration
//public class SecurityCorsConfiguration {
//
//    /**
//     * Security CORS URL 跨域资源共享 配置
//     *
//     * @return 返回 Security CORS URL 跨域资源共享 配置
//     */
//    @Bean
//    public UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 允许跨域的域
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:30001", "http://127.0.0.1:30001"));
//        // 浏览器是否应将凭据（如Cookie和跨域请求）
//        corsConfiguration.setAllowCredentials(true);
//        // 默认为 GET, HEAD, POST
//        // 可以为 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
//        corsConfiguration.setAllowedMethods(Arrays.asList(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name()));
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        // 地址
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return urlBasedCorsConfigurationSource;
//    }
//
//}
