package com.makefriends.manager;

import com.makefriends.domain.dto.entity.WishListInfo;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;

import java.util.List;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年10月21日
 * @version: 1.0
 */

public interface WishListInfoManager {

    Boolean wishListAdd(WishListInfo listInfo);


    List<WishListInfo> getWishListInfo(WishListResultRequest request);
}
