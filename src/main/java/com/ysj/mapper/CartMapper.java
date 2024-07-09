package com.ysj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysj.entity.Cart;
import com.ysj.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Mapper
@Repository
public interface CartMapper extends BaseMapper<Cart> {
    //查询购物车内的食品
    List<Food> selectCartInfo(@Param("uid") String uid);
    //将食品加入购物车
    void insertFoodIntoCart(@Param("uid") String uid,@Param("fid") String fid);
//    食品数量变化
    void updateFoodCount(@Param("fid") String fid,@Param("fcount") Integer fcount);
    //完成食品购买
    void FinshShopping(@Param("oid") String oid,@Param("username") String username,@Param("address") String address);
    //删除购物车商品
    void deleteByFid(@Param("fid")String fid);
    //完成购买后清空购物车
    void deleteByUid(@Param("uid")String uid);
    //记录用户与食品对照
    void orderConnect(@Param("uid") String uid,@Param("fid") String fid,@Param("oid") String oid);
}
