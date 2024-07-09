package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.Cart;
import com.ysj.entity.Food;
import com.ysj.mapper.CartMapper;
import com.ysj.service.CartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService{
    @Resource
    private CartMapper cartMapper;

    @Override
    public List<Food> selectCartInfo(String uid) {
        return cartMapper.selectCartInfo(uid);
    }

    @Override
    public void insertFoodIntoCart(String uid, String fid) {
        cartMapper.insertFoodIntoCart(uid,fid);
    }

    @Override
    public void updateFoodCount(String fid,Integer fcount) {
        cartMapper.updateFoodCount(fid,fcount);
    }

    @Override
    public void FinshShopping(String oid, String username, String address) {
        cartMapper.FinshShopping(oid,username,address);
    }

    @Override
    public void deleteByFid(String fid) {
        cartMapper.deleteByFid(fid);
    }

    @Override
    public void deleteByUid(String uid) {
        cartMapper.deleteByUid(uid);
    }

    @Override
    public void orderConnect(String uid, String fid,String oid) {
        cartMapper.orderConnect(uid,fid,oid);
    }

}
