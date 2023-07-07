package com.wangzaiplus.test.service.impl;

import com.wangzaiplus.test.common.ServerResponse;
import com.wangzaiplus.test.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年07月07日
 * @version: 1.0
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public ServerResponse testIdempotence() {
        return null;
    }

    @Override
    public ServerResponse accessLimit() {
        return null;
    }
}
