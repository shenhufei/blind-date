package com.wangzaiplus.test.controller;

import com.google.common.collect.Lists;
import com.wangzaiplus.test.annotation.AccessLimit;
import com.wangzaiplus.test.annotation.ApiIdempotent;
import com.wangzaiplus.test.common.ServerResponse;
import com.wangzaiplus.test.dto.UserDto;
import com.wangzaiplus.test.pojo.User;
import com.wangzaiplus.test.service.TestService;
import com.wangzaiplus.test.service.batch.mapperproxy.MapperProxy;
import com.wangzaiplus.test.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;




    @ApiIdempotent
    @PostMapping("testIdempotence")
    public ServerResponse testIdempotence() {
        return testService.testIdempotence();
    }

    @AccessLimit(maxCount = 5, seconds = 5)
    @PostMapping("accessLimit")
    public ServerResponse accessLimit() {
        return testService.accessLimit();
    }

    @GetMapping("send")
    public void sendMail() {

        System.out.println("dsds");
    }

    @PostMapping("single")
    public ServerResponse single(int size) {
        List<User> list = Lists.newArrayList();

        for (int i = 0; i < size; i++) {
            String str = RandomUtil.UUID32();
            User user = User.builder().username(str).password(str).build();
            list.add(user);
        }

        long startTime = System.nanoTime();
        log.info("batch insert costs: {} ms", (System.nanoTime() - startTime) / 1000000);

        return ServerResponse.success();
    }

    @PostMapping("batchInsert")
    public ServerResponse batchInsert(int size) {

        return ServerResponse.success();
    }

    @PostMapping("batchUpdate")
    public ServerResponse batchUpdate(String ids) {


        return ServerResponse.success();
    }

    @PostMapping("sync")
    public ServerResponse sync() {

        return ServerResponse.success();
    }

    @Async
    public void check(List<User> list) {

    }


    public static ThreadLocal<UserDto> userDtoThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        userDtoThreadLocal.set(UserDto.builder().build());
    }

}
