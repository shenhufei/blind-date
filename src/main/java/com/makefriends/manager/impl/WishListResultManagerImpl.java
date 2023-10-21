package com.makefriends.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.makefriends.domain.dto.entity.WishListResult;
import com.makefriends.domain.dto.reqeust.WishListResultRequest;
import com.makefriends.manager.WishListResultManager;
import com.makefriends.mapper.WishListResultMapper;
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
public class WishListResultManagerImpl extends ServiceImpl<WishListResultMapper, WishListResult>  implements WishListResultManager {
    @Autowired
    private WishListResultMapper wishListResultMapper;
    @Override
    public List<WishListResult> getUserWishList(WishListResultRequest request) {
        LambdaQueryWrapper<WishListResult> queryWrapper =  buildQueryWrapper(request);
        return wishListResultMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean deleteWishListResult() {
        LambdaQueryWrapper<WishListResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WishListResult::getSerialNumber, DateUtils.getCurrentDate());
        wishListResultMapper.delete(queryWrapper);
        return  Boolean.TRUE;
    }

    @Override
    public void batchAddWishResult(List<WishListResult> wishResultList) {
        saveBatch(wishResultList);
    }

    private LambdaQueryWrapper<WishListResult> buildQueryWrapper(WishListResultRequest request) {
        LambdaQueryWrapper<WishListResult> queryWrapper = new LambdaQueryWrapper<>();
        if(Objects.isNull(request.getOneselfNo())){
            queryWrapper.eq(WishListResult::getOneselfNo,request.getOneselfNo());
        }
        if(Objects.isNull(request.getWechatId())){
            queryWrapper.eq(WishListResult::getWechatId,request.getWechatId());
        }
        queryWrapper.eq(WishListResult::getSerialNumber, DateUtils.getCurrentDate());
        return  queryWrapper;
    }
}
