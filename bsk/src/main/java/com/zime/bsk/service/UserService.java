package com.zime.bsk.service;

import com.zime.bsk.entity.User;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 8:58
 */
public interface UserService {

    //通过id查询用户信息
    List<User> getUserById(Integer id);

    //通过手机号查询用户
    List<User> getUserByPhone(User user);

    //通过手机号和密码查询用户
    List<User> getUserByPwd(User user);

    //添加用户
    int addUser(User user);

    //更新用户
    int editUser(User user);

    //通过id删除用户
    int removeUser(Integer userId);
}
