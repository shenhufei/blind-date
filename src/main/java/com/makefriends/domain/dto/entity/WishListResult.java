package com.makefriends.domain.dto.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年10月21日
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName(value = "wish_list_result")
public class WishListResult implements Serializable {
    @Id
    /**
     * 主键id
     */
    @TableField(value="id")
    private Long id;

    /**
     *  创建时间
     */
    @TableField(value="created_date")
    private Date createdDate;

    /**
     * 修改时间
     */
    @TableField(value="updated_date")
    private Date updatedDate;

    /**
     * 是否删除：1删除；0 未删除
     */
    @TableField(value="is_deleted")
    private Integer isDeleted;

    /**
     * 序列号：主要用作唯一标致
     */
    @TableField(value="serial_number")
    private String serialNumber;

    /**
     * 微信号
     */
    @TableField(value="wechat_no")
    private String wechatNo;

    /**
     * 微信id
     */
    @TableField(value="wechat_id")
    private String wechatId;

    /**
     * 自己的编号
     */
    @TableField(value="oneself_no")
    private Integer oneselfNo;

    /**
     * 互选的编号
     */
    @TableField(value="wish_list_no")
    private String wishListNo;

}
