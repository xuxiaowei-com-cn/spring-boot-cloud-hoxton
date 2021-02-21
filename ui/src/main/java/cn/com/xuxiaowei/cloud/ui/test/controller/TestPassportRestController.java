package cn.com.xuxiaowei.cloud.ui.test.controller;

import cn.com.xuxiaowei.cloud.ui.test.hystrix.TestPassportHystrixService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    private TestPassportHystrixService testPassportHystrixService;

    private RestTemplate restTemplate;

    @Autowired
    public void setTestPassportHystrixService(TestPassportHystrixService testPassportHystrixService) {
        this.testPassportHystrixService = testPassportHystrixService;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 测试 登录 灰度发布
     *
     * @param request 请求
     * @return 返回 灰度发布
     */
    @RequestMapping("/echo")
    public String echo(HttpServletRequest request) {

        // 创建 Session
        HttpSession session = request.getSession();

        String gray = request.getHeader("gray");
        if (StringUtils.isNotEmpty(gray)) {
            if (Boolean.TRUE.toString().equals(gray)) {
                return testPassportHystrixService.echo("true");
            }
        }
        return testPassportHystrixService.echo("false");
    }

    /**
     * 测试 登录 灰度发布 {@link RestTemplate}
     *
     * @param request 请求
     * @return 返回 灰度发布
     */
    @RequestMapping("/echo-restTemplate")
    public String echoRestTemplate(HttpServletRequest request) {
        String gray = request.getHeader("gray");
        HttpHeaders headers = new HttpHeaders();
        if (StringUtils.isNotEmpty(gray)) {
            headers.add("gray",
                    Boolean.TRUE.toString().equals(gray) ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
        }
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://passport/test/echo", HttpMethod.GET, entity, String.class).getBody();
    }

}
