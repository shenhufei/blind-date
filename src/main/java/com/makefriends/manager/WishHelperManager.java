package com.makefriends.manager;

import com.makefriends.domain.dto.entity.WishListInfo;
import com.makefriends.domain.dto.entity.WishListResult;
import com.makefriends.domain.dto.reqeust.AddOrUpdateWishList;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.domain.dto.response.WishResultResponse;

public interface WishHelperManager {
    void buildSelfWishResult(WishResultResponse wishResult, WishListResult wishListResult);

    void buildSelfWishInfo(WishResultResponse wishResult, WishListInfo wishListInfo);

    void buildSelfInfo(WishResultResponse wishResult, WishListResultRequest request);

    WishListInfo buildWishListInfo(AddOrUpdateWishList info);
}
