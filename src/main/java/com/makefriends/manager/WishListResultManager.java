package com.makefriends.manager;

import com.makefriends.domain.dto.entity.WishListResult;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;

import java.util.List;

public interface WishListResultManager {
    List<WishListResult> getUserWishList(WishListResultRequest request);

    Boolean deleteWishListResult();

    void batchAddWishResult(List<WishListResult> wishResultList);
}
