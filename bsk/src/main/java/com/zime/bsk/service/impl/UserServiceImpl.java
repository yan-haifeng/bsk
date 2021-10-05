package com.zime.bsk.service.impl;

import com.zime.bsk.dao.UserMapper;
import com.zime.bsk.entity.User;
import com.zime.bsk.entity.UserExample;
import com.zime.bsk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserById(Integer id) {
        UserExample userExample = new UserExample();
        userExample.or().andUserIdEqualTo(id);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> getUserByPhone(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andUserPhoneEqualTo(user.getUserPhone());
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> getUserByPwd(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andUserPhoneEqualTo(user.getUserPhone()).andUserPwdEqualTo(user.getUserPwd());

        return userMapper.selectByExample(userExample);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int editUser(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andUserIdEqualTo(user.getUserId());
        return userMapper.updateByExampleSelective(user, userExample);
    }

    @Override
    public int removeUser(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
