package cn.com.xuxiaowei.cloud.passport.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestRestController {

    /**
     * 灰度发布
     *
     * @param request  请求
     * @param response 响应
     * @param session  Session
     * @return 返回 灰度发布
     */
    @RequestMapping("/echo")
    public String echo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String gray = request.getHeader("gray");
        return String.format("LocalAddr：%s，LocalPort：%s，Session：%s，Header gray：%s",
                request.getLocalAddr(), request.getLocalPort(), session.getId(), gray);
    }

}
