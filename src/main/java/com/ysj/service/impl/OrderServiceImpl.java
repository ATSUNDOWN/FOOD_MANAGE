package com.ysj.service.impl;

import cn.hutool.db.sql.Order;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.Food;
import com.ysj.entity.Ordering;
import com.ysj.mapper.OrderMapper;
import com.ysj.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Ordering> implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public void updateOrderStatus(Integer status,Integer id) {
        orderMapper.updateOrderStatus(status,id);
    }

    @Override
    public List<Food> checkOrderDetail(Integer id, String username) {
        return orderMapper.checkOrderDetail(id,username);
    }

    @Override
    public List<Food> checkMyOrder(String username) {
        return orderMapper.checkMyOrder(username);
    }
}
