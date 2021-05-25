//package cn.com.xuxiaowei.cloud.passport.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.*;
//
//import static cn.com.xuxiaowei.cloud.passport.utils.Constants.DEFAULT_CSRF_COOKIE_NAME;
//import static java.lang.Integer.parseInt;
//
///**
// * CSRF Cookie 策略 运行前 Filter
// *
// * @author xuxiaowei
// * @see CsrfFilter
// * @see CookieCsrfTokenRepository
// * @since 0.0.1
// */
//@Slf4j
//@Component
//public class CsrfCookieBeforeOncePerRequestFilter extends OncePerRequestFilter {
//
//    private final CsrfTokenRepository csrfTokenRepository;
//
//    public CsrfCookieBeforeOncePerRequestFilter(CsrfTokenRepository csrfTokenRepository) {
//        this.csrfTokenRepository = csrfTokenRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        // 获取 Session 中的 CSRF
//        CsrfToken csrfToken = csrfTokenRepository.loadToken(request);
//
//        if (csrfToken == null) {
//            log.debug("CsrfToken 为空");
//        } else {
//
//            String cookieName = DEFAULT_CSRF_COOKIE_NAME;
//
//            Cookie[] cookies = request.getCookies();
//
//            if (cookies == null) {
//                log.debug("Cookie 为空");
//            } else {
//                for (Cookie cookie : cookies) {
//                    if (cookie.getName().equals(cookieName)) {
//
//                        String cookieValue = cookie.getValue();
//
//                        // HttpServletRequest 设置为可修改 Header 的请求
//                        HeaderHttpServletRequestWrapper headerHttpServletRequestWrapper = new HeaderHttpServletRequestWrapper(request);
//
//                        // CSRF 请求头的 name
//                        String headerName = csrfToken.getHeaderName();
//
//                        // 修改 Header（CSRF Header）
//                        headerHttpServletRequestWrapper.addHeader(headerName, cookieValue);
//
//                        // 使用携带 CSRF Header 的请求
//                        filterChain.doFilter(headerHttpServletRequestWrapper, response);
//
//                        return;
//
//                    }
//                }
//
//                log.debug("未找到 Cookie Name: {}", cookieName);
//
//            }
//        }
//
//        // 执行后续程序
//        filterChain.doFilter(request, response);
//
//    }
//
//    /**
//     * {@link HttpServletRequest} Header 修改类
//     *
//     * @author xuxiaowei
//     * @see HttpServletRequest
//     * @since 0.0.1
//     */
//    public static class HeaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
//
//        /**
//         * 新 header 内容
//         */
//        private final Map<String, String> HEADER_MAP;
//
//        /**
//         * 原始请求
//         */
//        private final HttpServletRequest request;
//
//        /**
//         * 构造包装给定请求的请求对象。
//         *
//         * @param request 包装请求
//         * @throws IllegalArgumentException 如果请求为空
//         */
//        public HeaderHttpServletRequestWrapper(HttpServletRequest request) {
//            super(request);
//
//            HEADER_MAP = new HashMap<>();
//            this.request = request;
//
//            // 将原始 Headers 放入新 Headers（Map）中
//            Enumeration<String> enumeration = request.getHeaderNames();
//            while (enumeration.hasMoreElements()) {
//                String headerName = enumeration.nextElement();
//                String headerValue = request.getHeader(headerName);
//                HEADER_MAP.put(headerName, headerValue);
//            }
//
//        }
//
//        @Override
//        public String getHeader(String name) {
//            return HEADER_MAP.get(name);
//        }
//
//        @Override
//        public Enumeration<String> getHeaders(String name) {
//            String enumeration = HEADER_MAP.get(name);
//            Set<String> set = new HashSet<>();
//            if (enumeration != null) {
//                set.add(enumeration);
//            }
//            Enumeration<String> headerValues = request.getHeaders(name);
//            if (headerValues.hasMoreElements()) {
//                set.add(headerValues.nextElement());
//            }
//            return Collections.enumeration(set);
//        }
//
//        @Override
//        public Enumeration<String> getHeaderNames() {
//            Set<String> set = HEADER_MAP.keySet();
//            return Collections.enumeration(set);
//        }
//
//        /**
//         * @see HttpServletRequest#getIntHeader(String)
//         */
//        @Override
//        public int getIntHeader(String name) {
//            String headerValue = getHeader(name);
//            if (headerValue == null) {
//                return -1;
//            } else {
//                return parseInt(headerValue, 10);
//            }
//        }
//
//        /**
//         * 此方法用于添加 Header
//         *
//         * @param name  需要添加的 Header name
//         * @param value 需要添加的 Header value
//         */
//        public void addHeader(String name, String value) {
//            HEADER_MAP.put(name, value);
//        }
//
//        /**
//         * 此方法用于删除 Header
//         *
//         * @param name 需要删除的 Header name
//         */
//        public void removeHeader(String name) {
//            HEADER_MAP.remove(name);
//        }
//
//    }
//
//}
