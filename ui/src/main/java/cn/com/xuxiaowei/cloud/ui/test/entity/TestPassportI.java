package cn.com.xuxiaowei.cloud.ui.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户、登录模块测试表
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-01-19
 */
@Data
@Accessors(chain = true)
public class TestPassportI implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录模块测试表主键
     */
    private Long passportId;

    /**
     * 消息
     */
    private String passportMsg;

    /**
     * 数量
     */
    private Integer passportNum;

    /**
     * 用户模块测试表主键
     */
    private Long iId;

    /**
     * 消息
     */
    private String iMsg;

    /**
     * 数量
     */
    private Integer iNum;

}
