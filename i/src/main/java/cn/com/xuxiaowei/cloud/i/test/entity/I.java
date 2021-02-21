package cn.com.xuxiaowei.cloud.i.test.entity;

import cn.com.xuxiaowei.cloud.i.common.Entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * <p>
 * 用户模块测试表
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("test_i")
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class I extends Entity {

    private static final long serialVersionUID = 1L;

    /**
     * 登录模块测试表主键
     */
    @TableId(value = "i_id", type = IdType.AUTO)
    private Long iId;

    /**
     * 消息
     */
    @TableField("i_msg")
    private String iMsg;

    /**
     * 数量
     */
    @TableField("i_num")
    private Integer iNum;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建人用户名，不为空
     */
    @TableField("create_username")
    private String createUsername;

    /**
     * 更新人用户名
     */
    @TableField("update_username")
    private String updateUsername;

    /**
     * 创建时的IP，不为空
     */
    @TableField("create_ip")
    private String createIp;

    /**
     * 更新时的IP
     */
    @TableField("update_ip")
    private String updateIp;

    /**
     * 创建时间，MySQL 自动生成
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    /**
     * 更新时间，MySQL 自动生成
     */
    @TableField("update_date")
    private LocalDateTime updateDate;

    /**
     * 逻辑删除，0 未删除，1 删除，MySQL 默认值 0，不为 NULL，注解@TableLogic。
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;


    public static final String I_ID = "i_id";

    public static final String I_MSG = "i_msg";

    public static final String I_NUM = "i_num";

    public static final String REMARK = "remark";

    public static final String CREATE_USERNAME = "create_username";

    public static final String UPDATE_USERNAME = "update_username";

    public static final String CREATE_IP = "create_ip";

    public static final String UPDATE_IP = "update_ip";

    public static final String CREATE_DATE = "create_date";

    public static final String UPDATE_DATE = "update_date";

    public static final String DELETED = "deleted";

}
