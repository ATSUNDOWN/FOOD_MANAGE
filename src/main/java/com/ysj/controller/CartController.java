package com.ysj.controller;

import cn.hutool.core.util.IdUtil;
import com.ysj.common.Result;
import com.ysj.entity.Cart;
import com.ysj.entity.Category;
import com.ysj.entity.Food;
import com.ysj.mapper.CartMapper;
import com.ysj.service.CartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
@Controller
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;
    @Resource
    private CartMapper cartMapper;

//    将食品放入购物车
    @GetMapping("/insertFoodIntoCart")
    public Result<?> insertFoodIntoCart(@RequestParam(defaultValue = "")String uid,@RequestParam(defaultValue = "")String fid){
        cartService.insertFoodIntoCart(uid,fid);
        return Result.success();
    }
    //查询购物车内的信息
    @GetMapping("/selectCartInfo")
    public Result<?> selectCartInfo(@RequestParam(defaultValue = "")String uid){
        List<Food> list = cartService.selectCartInfo(uid);
        return Result.success(list);
    }

    //    删除购物车信息
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable long id){
        cartMapper.deleteById(id);
        return Result.success();
    }

    //更新购物车数量
    @GetMapping("/updateFoodNum")
    public Result<?> updateFoodNum(@RequestParam(defaultValue = "")String fid,@RequestParam(defaultValue = "")Integer fcount){
        cartService.updateFoodCount(fid,fcount);
        return Result.success();
    }

    @GetMapping("/finishShopping")
        //完成食品购买
    public Result<?> FinshShopping(@RequestParam(defaultValue = "") String oid,@RequestParam(defaultValue = "") String username,@RequestParam(defaultValue = "") String address){
        String flag = IdUtil.fastSimpleUUID();
        oid = oid + flag;
        cartService.FinshShopping(oid,username,address);
        return Result.success();
    }
    //按食物id删除购物车信息
    @GetMapping("/deleteCartInfo")
    public Result<?> deleteCartInfo(@RequestParam(defaultValue = "")String fid){
        cartService.deleteByFid(fid);
        return Result.success();
    }
    //完成购买后清空购物车
    @GetMapping("/deleteCartInfoByUid")
    public Result<?> deleteCartInfoByUid(@RequestParam(defaultValue = "")String uid){
        cartService.deleteByUid(uid);
        return Result.success();
    }

//    //    用于订单详情
//    @GetMapping("/orderConnect")
//    public Result<?> orderConnect(@RequestParam(defaultValue = "")String uid,@RequestParam(defaultValue = "")String fid,@RequestParam(defaultValue = "")String oid){
//        cartService.orderConnect(uid,fid,oid);
//        return Result.success();
//    }

}
