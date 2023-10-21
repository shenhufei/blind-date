package com.makefriends.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.makefriends.domain.dto.entity.WishListInfo;
import com.makefriends.domain.dto.entity.WishListResult;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.manager.WishListInfoManager;
import com.makefriends.mapper.WishListInfoMapper;
import com.makefriends.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年10月21日
 * @version: 1.0
 */
@Component
public class WishListInfoManagerImpl extends ServiceImpl<WishListInfoMapper, WishListInfo> implements WishListInfoManager {
    @Autowired
    private WishListInfoMapper wishListInfoMapper;
    @Override
    public Boolean wishListAdd(WishListInfo listInfo) {
        save(listInfo);
        return  Boolean.TRUE;
    }

    @Override
    public List<WishListInfo> getWishListInfo(WishListResultRequest request) {
        LambdaQueryWrapper<WishListInfo> queryWrapper = buildQueryWrapper(request);
        return wishListInfoMapper.selectList(queryWrapper);
    }


    private LambdaQueryWrapper<WishListInfo> buildQueryWrapper(WishListResultRequest request) {
        LambdaQueryWrapper<WishListInfo> queryWrapper = new LambdaQueryWrapper<>();
        if(Objects.isNull(request.getOneselfNo())){
            queryWrapper.eq(WishListInfo::getOneselfNo,request.getOneselfNo());
        }
        if(Objects.isNull(request.getWechatId())){
            queryWrapper.eq(WishListInfo::getWechatId,request.getWechatId());
        }
        queryWrapper.eq(WishListInfo::getSerialNumber, DateUtils.getCurrentDate());
        queryWrapper.orderByAsc(WishListInfo::getOneselfNo);
        return  queryWrapper;
    }

}
