package com.ysj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysj.entity.Food;
import com.ysj.entity.Ordering;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Ordering> {
//    改变订单状态，派送订单
void updateOrderStatus(@Param("status") Integer status,@Param("id") Integer id);
//        订单详情
List<Food> checkOrderDetail(@Param("id")Integer id, @Param("username") String username);
    //    查看个人订单
    List<Food> checkMyOrder(@Param("username")String username);
}
