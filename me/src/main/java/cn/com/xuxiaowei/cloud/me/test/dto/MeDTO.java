package cn.com.xuxiaowei.cloud.me.test.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户模块测试表
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * 创建人用户名，不为空
     */
    protected String createUsername;

    /**
     * 创建时的IP，不为空
     */
    protected String createIp;

}
