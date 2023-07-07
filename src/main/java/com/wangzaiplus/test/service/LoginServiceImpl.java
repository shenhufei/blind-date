package com.wangzaiplus.test.service;

import com.wangzaiplus.test.common.ServerResponse;
import com.wangzaiplus.test.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {


    @Override
    public ServerResponse doLogin(UserDto userDto) {
        return null;
    }

}
