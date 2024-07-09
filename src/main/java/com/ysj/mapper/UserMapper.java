package com.ysj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysj.entity.Food;
import com.ysj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    void recharge(@Param("balance")BigDecimal balance,@Param("username")String username);
    List<User> selectBalanceByUid(@Param("username") String username);


}

