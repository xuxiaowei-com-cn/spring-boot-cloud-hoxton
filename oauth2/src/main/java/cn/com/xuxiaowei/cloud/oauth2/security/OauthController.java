package cn.com.xuxiaowei.cloud.oauth2.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OAuth 2
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Controller
@RequestMapping("/oauth")
public class OauthController {

    /**
     * 自动授权
     *
     * @param request  请求
     * @param response 响应
     * @param code     代码
     * @param state    状态
     * @return 返回 授权后的页面
     */
    @RequestMapping("/auto/authorize")
    public String oauthAuthorize(HttpServletRequest request, HttpServletResponse response, String code, String state) {

        return "redirect:http://localhost:30001";
    }

}
