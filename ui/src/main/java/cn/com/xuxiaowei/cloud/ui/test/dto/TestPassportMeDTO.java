package cn.com.xuxiaowei.cloud.ui.test.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TestPassportMeDTO implements Serializable {

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
    private Long meId;

    /**
     * 消息
     */
    private String meMsg;

    /**
     * 数量
     */
    private Integer meNum;

}
