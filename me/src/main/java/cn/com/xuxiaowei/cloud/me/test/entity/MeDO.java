package cn.com.xuxiaowei.cloud.me.test.entity;

import cn.com.xuxiaowei.cloud.me.common.Entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户模块测试表
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("test_me")
public class MeDO extends Entity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户模块测试表主键
     */
    @TableId(value = "me_id", type = IdType.AUTO)
    private Long meId;

    /**
     * 消息
     */
    @TableField("me_msg")
    private String meMsg;

    /**
     * 数量
     */
    @TableField("me_num")
    private Integer meNum;


    public static final String ME_ID = "me_id";

    public static final String ME_MSG = "me_msg";

    public static final String ME_NUM = "me_num";

}
