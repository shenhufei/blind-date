package com.makefriends.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shenhufei
 * @description: 修改时间
 * @date 2023年10月21日
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WishResultResponse {


    /**
     * 微信号
     */
    private String wechatNo;

    /**
     * 微信号
     */
    private String wechatId;


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

    /**
     * 第一顺位选择结果
     */
    private Integer firstOrderResult;

    /**
     * 第二顺位选择结果
     */
    private Integer secondPriorityResult;

    /**
     * 第三顺位选择结果
     */
    private Integer thirdOrderResult;
}
