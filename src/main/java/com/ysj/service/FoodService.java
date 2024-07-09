package com.ysj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysj.entity.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodService extends IService<Food> {
    List<Food> getAllFoodInfo();
    List<Food> keyWordCheck(@Param("foodName") String search);
    List<Food> getFoodInfoById(@Param("id") Integer id);
    List<Food> getFoodInfoByFid(@Param("fid") String fid);
}
