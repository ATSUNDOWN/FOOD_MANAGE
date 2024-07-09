package com.ysj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysj.entity.Category;
import com.ysj.entity.Food;
import com.ysj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FoodMapper extends BaseMapper<Food> {
//    查询全部食物信息
    List<Food> getAllFoodInfo();
    //按关键词查询食物信息
    List<Food> keyWordCheck(@Param("foodName") String search);
    //按id查询食物信息
    List<Food> getFoodInfoById(@Param("id") Integer id);
    //按fid查询食物信息
    List<Food> getFoodInfoByFid(@Param("fid") String fid);
}

