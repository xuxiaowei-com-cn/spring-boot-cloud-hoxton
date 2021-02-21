package cn.com.xuxiaowei.cloud.ui.ribbon;

/**
 * Ribbon 请求上线文 {@link RibbonRequestContext} 线程管理
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class RibbonRequestContextHolder {

    private static final ThreadLocal<RibbonRequestContext> HOLDER = ThreadLocal.withInitial(RibbonRequestContext::new);

    public static RibbonRequestContext getCurrentContext() {
        return HOLDER.get();
    }

    public static void setCurrentContext(RibbonRequestContext currentContext) {
        HOLDER.set(currentContext);
    }

    public static void clearContext() {
        HOLDER.remove();
    }

}
