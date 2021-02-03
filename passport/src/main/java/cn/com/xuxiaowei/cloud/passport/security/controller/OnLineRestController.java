package cn.com.xuxiaowei.cloud.passport.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static cn.com.xuxiaowei.cloud.passport.enums.CodeEnums.OK;
import static cn.com.xuxiaowei.cloud.passport.utils.Constants.*;

/**
 * 在线 RestController
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/on-line")
public class OnLineRestController {

    /**
     * 是否在线
     *
     * @param request        请求
     * @param response       响应
     * @param authentication 认证方式
     * @return 返回 是否在线
     */
    @RequestMapping("/whether")
    public Map<String, Object> index(HttpServletRequest request, HttpServletResponse response,
                                     Authentication authentication) {
        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put(DATA, data);

        if (authentication == null) {
            data.put("whether", false);
        } else if (authentication instanceof AnonymousAuthenticationToken) {
            data.put("whether", false);
        } else if (authentication instanceof UsernamePasswordAuthenticationToken) {
            data.put("whether", true);
        } else {
            log.warn("警告，未找到匹配的用户认证方式");
            data.put("whether", false);
        }
        map.put(CODE, OK.code);
        map.put(MSG, OK.msg);
        return map;
    }

}
