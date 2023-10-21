package com.makefriends.service;

import com.makefriends.domain.dto.reqeust.AddOrUpdateWishList;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.domain.dto.response.WishResultResponse;

import java.util.List;

public interface WishListService {
    void wishListAdd(AddOrUpdateWishList addOrUpdateWishList);

    WishResultResponse getUserWishList(WishListResultRequest dto);

    List<WishResultResponse> getAllWishList(WishListResultRequest request);

    Boolean runWishResult(WishListResultRequest request);
}
