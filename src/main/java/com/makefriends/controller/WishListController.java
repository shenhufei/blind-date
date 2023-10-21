package com.makefriends.controller;

import com.makefriends.common.ServerResponse;
import com.makefriends.domain.dto.reqeust.AddOrUpdateWishList;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.domain.dto.response.WishResultResponse;
import com.makefriends.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wishList")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    /**
     * 心愿单添加
     * @param AddOrUpdateWishList
     * @return
     */
    @PostMapping("/add")
    public ServerResponse wishListAdd(@RequestBody AddOrUpdateWishList AddOrUpdateWishList) {
        wishListService.wishListAdd(AddOrUpdateWishList);
        return ServerResponse.success(Boolean.TRUE);
    }

    /**
     * 个人查询心愿单列表
     * @param WishListResultRequest
     * @return
     */
    @PostMapping("/getUserWishList")
    public ServerResponse getUserWishList(@RequestBody WishListResultRequest request) {
        WishResultResponse wishResult = wishListService.getUserWishList(request);
        return ServerResponse.success(wishResult);
    }

    /**
     * 个人查询心愿单列表
     * @param WishListResultRequest
     * @return
     */
    @PostMapping("/getAllWishList")
    public ServerResponse getAllWishList(@RequestBody WishListResultRequest request) {
        List<WishResultResponse> wishResult = wishListService.getAllWishList(request);
        return ServerResponse.success(wishResult);
    }

    /**
     * 手动跑心愿单结果
     * @param WishListResultRequest
     * @return
     */
    @PostMapping("/runWishResult")
    public ServerResponse runWishResult(@RequestBody WishListResultRequest request) {
        Boolean result  = wishListService.runWishResult(request);
        return ServerResponse.success(result);
    }


}
