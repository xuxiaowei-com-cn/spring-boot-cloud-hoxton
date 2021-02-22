package cn.com.xuxiaowei.cloud.me.test.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户模块测试表
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MeVO implements Serializable {

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
     * 备注
     */
    protected String remark;

    /**
     * 创建人用户名，不为空
     */
    protected String createUsername;

    /**
     * 更新人用户名
     */
    protected String updateUsername;

    /**
     * 创建时的IP，不为空
     */
    protected String createIp;

    /**
     * 更新时的IP
     */
    protected String updateIp;

    /**
     * 创建时间，MySQL 自动生成
     */
    protected LocalDateTime createDate;

    /**
     * 更新时间，MySQL 自动生成
     */
    protected LocalDateTime updateDate;

    /**
     * 逻辑删除，0 未删除，1 删除，MySQL 默认值 0，不为 NULL，注解@TableLogic。
     */
    protected Boolean deleted;

}
