package com.makefriends.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.makefriends.domain.dto.entity.WishListInfo;
import com.makefriends.domain.dto.entity.WishListResult;
import com.makefriends.domain.dto.reqeust.AddOrUpdateWishList;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.domain.dto.response.WishResultResponse;
import com.makefriends.manager.WishHelperManager;
import com.makefriends.manager.WishListInfoManager;
import com.makefriends.manager.WishListResultManager;
import com.makefriends.service.WishListService;
import com.makefriends.util.DateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年10月21日
 * @version: 1.0
 */
@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListInfoManager wishListInfoManager;

    @Autowired
    private WishListResultManager wishListResultManager;


    @Autowired
    private WishHelperManager wishHelperManager;

    public static List<Integer> RESULT_NO_LIST = new ArrayList<>();

    static {
        RESULT_NO_LIST.add(null);
        RESULT_NO_LIST.add(null);
        RESULT_NO_LIST.add(null);
    }



    @Override
    public void wishListAdd(AddOrUpdateWishList info) {
        //TODO 需要check 用户之前是否已经提交过；
        WishListInfo listInfo = wishHelperManager.buildWishListInfo(info);
        wishListInfoManager.wishListAdd(listInfo);
    }


    @Override
    public WishResultResponse getUserWishList(WishListResultRequest request) {
        WishResultResponse wishResult = new WishResultResponse();
        List<WishListResult> wishResutList = wishListResultManager.getUserWishList(request);
        List<WishListInfo> wishInfoList =wishListInfoManager.getWishListInfo(request);
        if(CollectionUtils.isNotEmpty(wishResutList)){
            WishListResult wishListResult = wishResutList.get(0);
            //组装自己的心愿结果；
            wishHelperManager.buildSelfWishResult(wishResult,wishListResult);
        }
        if(CollectionUtils.isNotEmpty(wishInfoList)){
            WishListInfo wishListInfo = wishInfoList.get(0);
            //组装自己的心愿结果；
            wishHelperManager.buildSelfWishInfo(wishResult,wishListInfo);
        }
        wishHelperManager.buildSelfInfo(wishResult,request);
        return wishResult;
    }



    @Override
    public List<WishResultResponse> getAllWishList(WishListResultRequest request) {
        List<WishResultResponse> resultList = new ArrayList<>();
        List<WishListResult> wishResutList = wishListResultManager.getUserWishList(request);
        List<WishListInfo> wishInfoList =wishListInfoManager.getWishListInfo(request);
        Map<Integer, WishListResult> resultMap = wishResutList.stream().collect(Collectors.toMap(WishListResult::getOneselfNo, a -> a,(k1, k2)->k1));
        for(WishListInfo info: wishInfoList){
            WishResultResponse response = new WishResultResponse();
            //构建当前用户自身的心愿选择；
            wishHelperManager.buildSelfWishInfo(response,info);
            WishListResult wishListResult = resultMap.get(info.getOneselfNo());
            if(Objects.isNull(wishListResult)){
                continue;
            }
            //构建当前用户自身的心愿结果；
            wishHelperManager.buildSelfWishResult(response,wishListResult);
            resultList.add(response);
        }
        return resultList;
    }

    @Override
    public Boolean runWishResult(WishListResultRequest request) {
        wishListResultManager.deleteWishListResult();
        List<WishListInfo> wishInfoList =wishListInfoManager.getWishListInfo(request);
        Map<Integer, WishListInfo> resultMap = wishInfoList.stream().collect(Collectors.toMap(WishListInfo::getOneselfNo, a -> a,(k1, k2)->k1));
        //遍历
        Set<Map.Entry<Integer, WishListInfo>> entrySet = resultMap.entrySet();
        List<WishListResult> wishResultList = new ArrayList<>();
        for(Map.Entry<Integer, WishListInfo> entry:  entrySet){
            WishListResult result =new WishListResult();
            WishListInfo value = entry.getValue();
            //自己的心愿单选择
            List<Integer> myselfWish = JSONArray.parseArray(value.getWishListNo(), Integer.class);
            //筛选出不是自己的；
            List<WishListInfo> filterList = wishInfoList.stream().filter(item -> entry.getKey().compareTo(item.getOneselfNo()) != 0).collect(Collectors.toList());
            for(WishListInfo info:  filterList){
                List<Integer> otherWishList = JSONArray.parseArray(info.getWishListNo(), Integer.class);
                //自己的心愿单选择和被人的心愿单选择取交集；
                Collection intersection = CollectionUtils.intersection(myselfWish, otherWishList);
                //不存在交集，则表示互选失败了；
                if(CollectionUtils.isEmpty(intersection)){
                    continue;
                }
                //存在交集，表示互选成功；
                List<Integer> resultNoList = new ArrayList<>(intersection);
                for(Integer no:  resultNoList){
                    int index = myselfWish.indexOf(no);
                    RESULT_NO_LIST.add(index,info.getOneselfNo());
                }
                result.setWishListNo(JSONArray.toJSONString(RESULT_NO_LIST));
                result.setOneselfNo(entry.getKey());
                result.setWechatId(value.getWechatId());
                result.setWechatNo(value.getWechatNo());
                result.setSerialNumber(DateUtils.getCurrentDate());
                wishResultList.add(result);
            }
        }
        wishListResultManager.batchAddWishResult(wishResultList);
        return Boolean.TRUE;
    }

}
