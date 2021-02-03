package cn.com.xuxiaowei.cloud.passport.utils;

/**
 * 常量
 *
 * @author xuxiaowei
 * @see org.springframework.http.MediaType spring-web，从 3.0 开始
 * @see org.springframework.util.MimeTypeUtils spring-core，从 4.0 开始
 * @see org.springframework.http.HttpHeaders spring-web，从 3.0 开始
 * @see com.google.common.net.HttpHeaders guava，从 11.0 开始
 * @see javax.servlet.http.HttpServletResponse
 * @see org.springframework.web.context.support.XmlWebApplicationContext spring-web
 * @see org.springframework.context.ApplicationContextAware spring-context，可获取 {@link org.springframework.context.ApplicationContext}，非常量相关
 * @see org.springframework.web.util.JavaScriptUtils spring-web，从 1.1.1 开始，将JavaScript特殊字符转换为转义字符，非常量相关
 * @see org.springframework.web.servlet.view.json.MappingJackson2JsonView spring-webmvc，从 3.1.2 开始
 * @see org.springframework.web.context.WebApplicationContext
 * @see java.nio.charset.StandardCharsets
 * @see sun.nio.cs.StandardCharsets
 * @since 0.0.1
 */
public final class Constants {


    //////////////////////////////////////////////////  响应  //////////////////////////////////////////////////


    /**
     * 响应代码
     */
    public static final String CODE = "code";

    /**
     * 响应消息
     */
    public static final String MSG = "msg";

    /**
     * 响应数据
     */
    public static final String DATA = "data";


    //////////////////////////////////////////////////  format  //////////////////////////////////////////////////


    /**
     * Spring format 使用格式
     *
     * @see String#format(String, Object...)
     */
    public static final String COMMA = "%s,%s";


    //////////////////////////////////////////////////  时间  //////////////////////////////////////////////////


    /**
     * 日期时间格式
     */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间格式（全）
     */
    public static final String ALL_DATE_TIME_FORMAT = "yyyyMMddHHmmssSSS";

    /**
     * 日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 时间格式
     */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";


    //////////////////////////////////////////////////  编码  //////////////////////////////////////////////////


    /**
     * 编码
     *
     * @see java.nio.charset.StandardCharsets#UTF_8 rt.jar
     */
    public static final String UTF_8 = "UTF-8";


    //////////////////////////////////////////////////  OAuth2  //////////////////////////////////////////////////


    /**
     * ASCCESS TOKEN
     *
     * @see org.springframework.security.oauth2.common.OAuth2AccessToken#ACCESS_TOKEN
     */
    public static final String ASCCESS_TOKEN = "access_token";

    /**
     * OAUTH2_TYPE
     *
     * @see org.springframework.security.oauth2.common.OAuth2AccessToken#ACCESS_TOKEN
     */
    public static final String OAUTH2_TYPE = "OAuth2";

    /**
     * EXPIRES_IN
     *
     * @see org.springframework.security.oauth2.common.OAuth2AccessToken#EXPIRES_IN
     */
    public static final String EXPIRES_IN = "expires_in";

    /**
     * REFRESH_TOKEN
     *
     * @see org.springframework.security.oauth2.common.OAuth2AccessToken#REFRESH_TOKEN
     */
    public static final String REFRESH_TOKEN = "refresh_token";


    //////////////////////////////////////////////////  Header  //////////////////////////////////////////////////


    /**
     * 必须先与服务器确认返回的响应是否被更改，然后才能使用该响应来满足后续对同一个网址的请求。
     * 因此，如果存在合适的验证令牌 (ETag)，no-cache 会发起往返通信来验证缓存的响应，如果资源未被更改，可以避免下载。
     *
     * @see <a href="https://baike.baidu.com/item/Cache-control/1885913">Cache-control</a>
     * @see com.google.common.net.HttpHeaders#CACHE_CONTROL
     * @see org.springframework.http.HttpHeaders#CACHE_CONTROL
     */
    public static final String NO_CACHE = "no-cache";

    /**
     * 所有内容都不会被缓存到缓存或 Internet 临时文件中
     *
     * @see <a href="https://baike.baidu.com/item/Cache-control/1885913">Cache-control</a>
     * @see com.google.common.net.HttpHeaders#CACHE_CONTROL
     * @see org.springframework.http.HttpHeaders#CACHE_CONTROL
     */
    public static final String NO_STORE = "no-store";

    /**
     * 1、所有内容都不会被缓存到缓存或 Internet 临时文件中
     * <p>
     * 2、必须先与服务器确认返回的响应是否被更改，然后才能使用该响应来满足后续对同一个网址的请求。
     * 因此，如果存在合适的验证令牌 (ETag)，no-cache 会发起往返通信来验证缓存的响应，如果资源未被更改，可以避免下载。
     *
     * @see #NO_CACHE
     * @see #NO_STORE
     * @see <a href="https://baike.baidu.com/item/Cache-control/1885913">Cache-control</a>
     * @see com.google.common.net.HttpHeaders#CACHE_CONTROL
     * @see org.springframework.http.HttpHeaders#CACHE_CONTROL
     */
    public static final String NO_CACHE_NO_STORE = String.format(COMMA, NO_CACHE, NO_STORE);


    //////////////////////////////////////////////////  Header  //////////////////////////////////////////////////


    /**
     * Microsoft Excel
     *
     * @see com.google.common.net.MediaType#MICROSOFT_EXCEL
     */
    public static final String MICROSOFT_EXCEL = "application/vnd.ms-excel";

    /**
     * PDF
     *
     * @see com.google.common.net.MediaType#PDF
     */
    public static final String PDF = "application/pdf";

    /**
     * ZIP
     *
     * @see com.google.common.net.MediaType#ZIP
     */
    public static final String ZIP = "application/zip";

    /**
     * text/css
     *
     * @see com.google.common.net.MediaType#CSS_UTF_8
     */
    public static final String CSS_UTF_8 = "text/css";

    /**
     * text/csv
     *
     * @see com.google.common.net.MediaType#CSV_UTF_8
     */
    public static final String CSV_UTF_8 = "text/csv";

    /**
     * text/html
     *
     * @see com.google.common.net.MediaType#HTML_UTF_8
     */
    public static final String HTML_UTF_8 = "text/html";

    /**
     * PNG
     *
     * @see com.google.common.net.MediaType#PNG
     * @see org.springframework.util.MimeTypeUtils#IMAGE_PNG_VALUE
     */
    public static final String PNG = "image/png";

    /**
     * Expires
     *
     * @see org.springframework.http.HttpHeaders#EXPIRES
     */
    public static final String EXPIRES = "Expires";

    /**
     * Date
     *
     * @see org.springframework.http.HttpHeaders#DATE
     */
    public static final String DATE = "Date";

    /**
     * Last-Modified
     *
     * @see org.springframework.http.HttpHeaders#LAST_MODIFIED
     */
    public static final String LAST_MODIFIED = "Last-Modified";

    /**
     * Pragma
     *
     * @see org.springframework.http.HttpHeaders#PRAGMA
     */
    public static final String PRAGMA = "Pragma";

    /**
     * Cache-Control
     *
     * @see org.springframework.http.HttpHeaders#CACHE_CONTROL
     */
    public static final String CACHE_CONTROL = "Cache-Control";


    //////////////////////////////////////////////////  CSRF  //////////////////////////////////////////////////


    /**
     * Cookie 名
     *
     * @see org.springframework.security.web.csrf.CookieCsrfTokenRepository#DEFAULT_CSRF_COOKIE_NAME
     */
    public static final String DEFAULT_CSRF_COOKIE_NAME = "XSRF-TOKEN";

    /**
     * CSRF 参数名
     *
     * @see org.springframework.security.web.csrf.CookieCsrfTokenRepository#DEFAULT_CSRF_PARAMETER_NAME
     */
    public static final String DEFAULT_CSRF_PARAMETER_NAME = "_csrf";

    /**
     * CSRF Header 参数名
     *
     * @see org.springframework.security.web.csrf.CookieCsrfTokenRepository#DEFAULT_CSRF_HEADER_NAME
     */
    public static final String DEFAULT_CSRF_HEADER_NAME = "X-XSRF-TOKEN";


}
