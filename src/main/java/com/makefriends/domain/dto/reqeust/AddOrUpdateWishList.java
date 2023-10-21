package com.makefriends.domain.dto.reqeust;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class AddOrUpdateWishList implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 微信号
     */
    private String wechatNo;

    /**
     * 微信号
     */
    private String wechatId;

    /**
     * 微信其他信息
     */
    private String wechatDetail;

    /**
     * 性别：0 女 ：1 男
     */
    @TableField(value="sex")
    private Integer sex;


    /**
     * 自己的编号
     */
    private Integer oneselfNo;

    /**
     * 第一顺位选择
     */
    private Integer firstOrder;

    /**
     * 第二顺位选择
     */
    private Integer secondPriority;

    /**
     * 第三顺位选择
     */
    private Integer thirdOrder;


}
