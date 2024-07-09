package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.User;
import com.ysj.mapper.UserMapper;
import com.ysj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void recharge(BigDecimal balance, String username) {
        userMapper.recharge(balance,username);
    }

    @Override
    public List<User> selectBalanceByUid(String username) {
        return userMapper.selectBalanceByUid(username);
    }
}
