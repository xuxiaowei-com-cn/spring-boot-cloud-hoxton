//package cn.com.xuxiaowei.cloud.passport.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * MVC CORS 跨域资源共享 配置
// *
// * @author xuxiaowei
// * @since 0.0.1
// */
//@Configuration
//public class WebMvcConfigurerConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        // 允许路径，需要提供协议、端口
//        registry
//                // 地址
//                .addMapping("/**")
//                // 允许跨域的域
//                .allowedOrigins("http://localhost:30001", "http://127.0.0.1:30001")
//                // 默认为 GET, HEAD, POST
//                // 可以为 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
//                .allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name())
//                // 默认为 1800秒（30分钟）
//                .maxAge(1800)
//                // 浏览器是否应将凭据（如Cookie和跨域请求）
//                .allowCredentials(true);
//
//    }
//
//}
