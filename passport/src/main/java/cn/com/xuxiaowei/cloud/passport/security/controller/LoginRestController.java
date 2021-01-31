package cn.com.xuxiaowei.cloud.passport.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
@RequestMapping("/login")
public class LoginRestController {

    /**
     * 登录成功
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 登录成功
     */
    @RequestMapping("/success")
    public Map<String, Object> success(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("msg", "登录成功");
        return map;
    }

    /**
     * 登录失败
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 登录失败
     */
    @RequestMapping("/failure")
    public Map<String, Object> failure(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("msg", "登录失败");
        return map;
    }

}
