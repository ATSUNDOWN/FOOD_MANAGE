package com.ysj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface UserService extends IService<User> {
    void recharge(@Param("balance") BigDecimal balance,@Param("username")String username);
    List<User> selectBalanceByUid(@Param("username") String username);

}
