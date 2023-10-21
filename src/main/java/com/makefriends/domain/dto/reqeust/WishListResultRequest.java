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
public class WishListResultRequest implements Serializable {

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
     * 自己的编号
     */
    private Integer oneselfNo;


}
