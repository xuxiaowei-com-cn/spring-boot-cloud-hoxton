package cn.com.xuxiaowei.cloud.ui.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * UI 模块异常
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class UiException extends Exception {

    private String code;

    private String msg;

    private String logMsg;

    public UiException(String code, String msg) {
        this(msg);
        this.code = code;
        this.msg = msg;
    }

    public UiException(String code, String msg, String logMsg) {
        this(msg);
        this.code = code;
        this.msg = msg;
        this.logMsg = logMsg;
    }

    private UiException() {
    }

    private UiException(String message) {
        super(message);
    }

    private UiException(String message, Throwable cause) {
        super(message, cause);
    }

    private UiException(Throwable cause) {
        super(cause);
    }

    private UiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
