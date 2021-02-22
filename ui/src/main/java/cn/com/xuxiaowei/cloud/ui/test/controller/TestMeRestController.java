package cn.com.xuxiaowei.cloud.ui.test.controller;

import cn.com.xuxiaowei.cloud.ui.test.dto.TestPassportMeDTO;
import cn.com.xuxiaowei.cloud.ui.test.hystrix.TestMeHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 测试 用户模块 RestController
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/test/me")
public class TestMeRestController {

    private TestMeHystrixService testMeHystrixService;

    @Autowired
    public void setTestMeHystrixService(TestMeHystrixService testMeHystrixService) {
        this.testMeHystrixService = testMeHystrixService;
    }

    /**
     * 测试 用户模块 参数接收、保存数据 接口
     *
     * @param request           请求
     * @param response          响应
     * @param session           session
     * @param testPassportMeDTO 用户模块测试表，必填，否则调用失败
     * @return 返回 测试 用户模块 结果
     */
    @RequestMapping(value = "/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                    @RequestBody TestPassportMeDTO testPassportMeDTO) {
        return testMeHystrixService.save(testPassportMeDTO);
    }

}
