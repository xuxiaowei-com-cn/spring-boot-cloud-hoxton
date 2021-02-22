package cn.com.xuxiaowei.cloud.passport.test.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 登录模块测试表
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PassportDTO implements Serializable {

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
     * 创建人用户名，不为空
     */
    protected String createUsername;

    /**
     * 创建时的IP，不为空
     */
    protected String createIp;

}
