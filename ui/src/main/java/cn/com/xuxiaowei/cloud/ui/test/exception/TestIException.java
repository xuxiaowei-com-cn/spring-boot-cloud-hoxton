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
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class TestIException extends UiException {

    public TestIException(String code, String msg) {
        super(code, msg);
    }

    public TestIException(String code, String msg, String logMsg) {
        super(code, msg, logMsg);
    }

}
