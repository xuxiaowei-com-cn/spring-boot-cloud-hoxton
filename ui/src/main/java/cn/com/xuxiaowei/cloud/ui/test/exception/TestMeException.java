package cn.com.xuxiaowei.cloud.ui.test.exception;

import cn.com.xuxiaowei.cloud.ui.exception.UiException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 测试用户模块 异常
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class TestMeException extends UiException {

    public TestMeException(String code, String msg) {
        super(code, msg);
    }

    public TestMeException(String code, String msg, String logMsg) {
        super(code, msg, logMsg);
    }

}
