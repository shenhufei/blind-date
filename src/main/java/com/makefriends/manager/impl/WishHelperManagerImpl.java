package com.makefriends.manager.impl;

import com.alibaba.fastjson.JSONArray;
import com.makefriends.domain.dto.entity.WishListInfo;
import com.makefriends.domain.dto.entity.WishListResult;
import com.makefriends.domain.dto.reqeust.AddOrUpdateWishList;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.domain.dto.response.WishResultResponse;
import com.makefriends.manager.WishHelperManager;
import com.makefriends.util.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年10月21日
 * @version: 1.0
 */
@Component
public class WishHelperManagerImpl implements WishHelperManager {


    /**
     * 构建当前用户自身的心愿结果；
     * @param response
     * @param result
     */
    @Override
    public void buildSelfWishResult(WishResultResponse response, WishListResult result) {
        List<Integer> resultList = JSONArray.parseArray(result.getWishListNo(), Integer.class);
        response.setFirstOrderResult(resultList.get(0));
        response.setSecondPriorityResult(resultList.get(1));
        response.setThirdOrderResult(resultList.get(2));

    }

    /**
     *构建当前用户自身的心愿选择；
     * @param response
     * @param info
     */
    @Override
    public void buildSelfWishInfo(WishResultResponse response, WishListInfo info) {
        List<Integer> resultList = JSONArray.parseArray(info.getWishListNo(), Integer.class);
        response.setFirstOrder(resultList.get(0));
        response.setSecondPriority(resultList.get(1));
        response.setThirdOrder(resultList.get(2));
        response.setOneselfNo(info.getOneselfNo());
        response.setWechatId(info.getWechatId());
        response.setWechatNo(info.getWechatNo());
    }


    /**
     * 构建自身信息
     * @param wishResult
     * @param request
     */
    @Override
    public void buildSelfInfo(WishResultResponse wishResult, WishListResultRequest request) {
        wishResult.setOneselfNo(request.getOneselfNo());
        wishResult.setWechatId(request.getWechatId());
        wishResult.setWechatNo(request.getWechatNo());

    }

    @Override
    public WishListInfo buildWishListInfo(AddOrUpdateWishList info) {
        WishListInfo listInfo = new WishListInfo();
        List<Integer> orderList = Arrays.asList(info.getFirstOrder(),info.getSecondPriority(),info.getThirdOrder());
        listInfo.setOneselfNo(info.getOneselfNo());
        listInfo.setSex(info.getSex());
        listInfo.setWishListNo(JSONArray.toJSONString(orderList));
        listInfo.setWechatNo(info.getWechatNo());
        listInfo.setWechatDetail(info.getWechatDetail());
        listInfo.setSerialNumber(DateUtils.getCurrentDate());
        return listInfo;
    }
}
