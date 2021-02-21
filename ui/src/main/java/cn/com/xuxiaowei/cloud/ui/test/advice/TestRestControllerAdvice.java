package cn.com.xuxiaowei.cloud.ui.test.advice;

import cn.com.xuxiaowei.cloud.ui.test.exception.TestPassportException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 异常拦截
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestControllerAdvice(basePackages = {"cn.com.xuxiaowei.cloud.ui.test"})
public class TestRestControllerAdvice {

    /**
     * 测试登录模块 异常
     *
     * @param e 异常
     * @return 返回 异常数据
     */
    @ExceptionHandler(TestPassportException.class)
    public Map<String, Object> testPassportException(TestPassportException e) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        log.error("测试登录模块 异常", e);
        return map;
    }

}