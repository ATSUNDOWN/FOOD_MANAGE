package com.ysj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.common.Result;
import com.ysj.entity.Food;
import com.ysj.entity.Ordering;
import com.ysj.mapper.OrderMapper;
import com.ysj.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@Controller
@RequestMapping("/ordering")
public class OrderController {
    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderService orderService;
    //    查询全部订单
    @GetMapping
    public Result<?> findPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Ordering> wrapper = Wrappers.<Ordering>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Ordering::getUsername,search);
        }
        wrapper.between(Ordering::getStatus,1,2);
        Page<Ordering> OrderingPage = orderMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(OrderingPage);
    }
    @GetMapping("/updateOrderStatus")
    public Result<?> updateOrderStatus(@RequestParam(defaultValue = "") Integer status,@RequestParam(defaultValue = "") Integer id){
        orderService.updateOrderStatus(status,id);
        return Result.success();
    }
    @GetMapping("/checkOrderDetail")
    public Result<?> checkOrderDetail(@RequestParam(defaultValue = "")Integer id,@RequestParam(defaultValue = "")String username) {
        List<Food> list = orderService.checkOrderDetail(id,username);
        return Result.success(list);
    }
    @GetMapping("/checkMyOrder")
    public Result<?> checkMyOrder(@RequestParam(defaultValue = "")String username){
        List<Food> list = orderService.checkMyOrder(username);
        return Result.success(list);
    }
    //查询个人订单
    //    查询
    @GetMapping("/findMyOrderPage")
    public Result<?> findMyOrderPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String username){
        LambdaQueryWrapper<Ordering> wrapper = Wrappers.<Ordering>lambdaQuery();
        wrapper.like(Ordering::getUsername,username);
        wrapper.between(Ordering::getStatus,1,2);
        Page<Ordering> OrderingPage = orderMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(OrderingPage);
    }


}
