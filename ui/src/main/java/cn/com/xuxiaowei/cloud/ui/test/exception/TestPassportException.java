package cn.com.xuxiaowei.cloud.ui.test.exception;

import cn.com.xuxiaowei.cloud.ui.exception.UiException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 测试登录模块 异常
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class TestPassportException extends UiException {

    public TestPassportException(String code, String msg) {
        super(code, msg);
    }

    public TestPassportException(String code, String msg, String logMsg) {
        super(code, msg, logMsg);
    }

}
