package com.wangzaiplus.test.service.impl;

import com.wangzaiplus.test.common.ServerResponse;
import com.wangzaiplus.test.pojo.User;
import com.wangzaiplus.test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年07月07日
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getOne(Integer id) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public ServerResponse login(String username, String password) {
        return null;
    }

    @Override
    public void batchInsert(List<User> list) {

    }

    @Override
    public void batchUpdate(List<User> list) {

    }
}
