package cn.com.xuxiaowei.cloud.ui.ribbon;

import java.util.HashMap;
import java.util.Map;

/**
 * Ribbon 请求上线文
 * <p>
 * 用于在线程中暂时储存本次请求内容
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class RibbonRequestContext {

    private final Map<String, String> MAP = new HashMap<>();

    public String put(String key, String value) {
        return MAP.put(key, value);
    }

    public String remove(String key) {
        return MAP.remove(key);
    }

    public String get(String key) {
        return MAP.get(key);
    }

}
