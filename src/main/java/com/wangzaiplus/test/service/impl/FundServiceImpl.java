package com.wangzaiplus.test.service.impl;

import com.google.common.collect.Lists;
import com.wangzaiplus.test.common.Constant;
import com.wangzaiplus.test.common.ServerResponse;
import com.wangzaiplus.test.dto.FundDto;
import com.wangzaiplus.test.dto.SearchFormDto;
import com.wangzaiplus.test.pojo.Fund;
import com.wangzaiplus.test.service.FundService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FundServiceImpl implements FundService {



    @Override
    public ServerResponse search(SearchFormDto searchFormDto) {
       return null;
    }



    @Override
    public void update(List<FundDto> list) {

    }

    @Override
    public ServerResponse rank(FundDto fundDto) {
        return null;
    }



    private Fund toFund(FundDto fundDto) {
        Fund fund = Fund.builder().build();
        BeanUtils.copyProperties(fundDto, fund);
        return fund;
    }

    private List<FundDto> toFundDtoList(List<Fund> fundList) {
        if (CollectionUtils.isEmpty(fundList)) {
            return null;
        }

        return fundList.stream().map(fund -> {
            FundDto fundDto = FundDto.builder().build();
            BeanUtils.copyProperties(fund, fundDto);
            fundDto.setTypeDesc(Constant.FundType.getDescByType(fundDto.getType()));
            return fundDto;
        }).collect(Collectors.toList());
    }



    private List<String> toRankList(String rankStr) {
        if (StringUtils.isBlank(rankStr)) {
            return emptyRankList();
        }

        String[] split = rankStr.split(Constant.COMMA);
        if (null == split || split.length != 4) {
            log.error("error rankStr: {}", rankStr);
            return emptyRankList();
        }

        return Arrays.asList(split);
    }

    private List<String> emptyRankList() {
        return Lists.newArrayList(Constant.DOUBLE_STRIGULA, Constant.DOUBLE_STRIGULA, Constant.DOUBLE_STRIGULA, Constant.DOUBLE_STRIGULA);
    }

    @Override
    public ServerResponse getSearchFormDto() {
        SearchFormDto searchFormDto = SearchFormDto.builder()
                .typeList(Constant.FundType.getTypeList())
                .yieldList(Constant.FundYield.getYieldList())
                .rankList(Constant.FundRank.getRankList())
                .build();
        return ServerResponse.success(searchFormDto);
    }



    private String getFundRankPrefix(Integer type, Integer id) {
        return Constant.Redis.FUND_RANK + Constant.COLON + type + Constant.COLON + id;
    }

}
