package cn.com.xuxiaowei.cloud.ui.test.controller;

import cn.com.xuxiaowei.cloud.ui.test.entity.TestPassportMe;
import cn.com.xuxiaowei.cloud.ui.test.hystrix.TestPassportHystrixService;
import cn.com.xuxiaowei.cloud.ui.utils.http.HeadersUtils;
import com.baomidou.dynamic.datasource.annotation.DS;
import io.micrometer.core.instrument.util.StringUtils;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 测试 登录模块 RestController
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

        // 分布式事务传递 TX_XID
        HeadersUtils.xid(request, headers);
        // 添加 Http Header（用于传递 Headers，Session 共享）
        HeadersUtils.add(request, headers);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://me/test/echo", HttpMethod.GET, entity, String.class).getBody();
    }

    /**
     * 测试 登录模块 参数接收、保存数据 接口
     *
     * @param request       请求
     * @param response      响应
     * @param session       session
     * @param testPassportMe 登录模块测试表，必填，否则调用失败
     * @return 返回 测试 登录模块 结果
     */
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    @RequestMapping(value = "/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                    @RequestBody TestPassportMe testPassportMe) {
        return testPassportHystrixService.save(testPassportMe);
    }

}
