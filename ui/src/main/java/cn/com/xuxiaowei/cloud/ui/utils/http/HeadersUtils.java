package cn.com.xuxiaowei.cloud.ui.utils.http;

import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Headers 工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class HeadersUtils {

    /**
     * 分布式事务传递 TX_XID
     *
     * @param request 请求
     * @param headers Http Header
     */
    public static void xid(HttpServletRequest request, HttpHeaders headers) {
        // 分布式事务传递 TX_XID
        String xid = RootContext.getXID();
        if (StringUtils.isNotEmpty(xid)) {
            headers.add(RootContext.KEY_XID, xid);
        }
    }

    /**
     * 添加 Http Header
     *
     * @param request 请求
     * @param headers Http Header
     */
    public static void add(HttpServletRequest request, HttpHeaders headers) {
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                // 过滤 Content-Length，防止接收不到响应
                if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(headerName)) {
                    headers.add(headerName, headerValue);
                }
            }
        }
    }

}
