package com.wangzaiplus.test.service.impl;

import com.wangzaiplus.test.pojo.LoginLog;
import com.wangzaiplus.test.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl implements LoginLogService {



    @Override
    public void insert(LoginLog loginLog) {

    }

    @Override
    public LoginLog selectByMsgId(String msgId) {
        return null;
    }

}
