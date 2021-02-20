package cn.com.xuxiaowei.cloud.ui.test.controller;

import cn.com.xuxiaowei.cloud.ui.test.feign.TestPassportService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试 登录 RestController
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/test/passport")
public class TestPassportRestController {

    private TestPassportService testPassportService;

    @Autowired
    public void setTestPassportService(TestPassportService testPassportService) {
        this.testPassportService = testPassportService;
    }

    /**
     * 测试 登录 灰度发布
     *
     * @param request 请求
     * @return 返回 灰度发布
     */
    @RequestMapping("/echo")
    public String echo(HttpServletRequest request) {
        String gray = request.getHeader("Gray");
        if (StringUtils.isNotEmpty(gray)) {
            if (Boolean.TRUE.toString().equals(gray)) {
                return testPassportService.echo("true");
            }
        }
        return testPassportService.echo("false");
    }

}
