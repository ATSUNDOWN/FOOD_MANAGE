package com.ysj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysj.entity.Food;
import com.ysj.entity.Ordering;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService extends IService<Ordering> {
//    更新订单状态
    void updateOrderStatus(@Param("status") Integer status,@Param("id") Integer id);
//    查看订单详情
    List<Food> checkOrderDetail(@Param("id")Integer id, @Param("username") String username);
//    查看个人订单
    List<Food> checkMyOrder(@Param("username")String username);
}
