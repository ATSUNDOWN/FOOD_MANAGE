package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.Food;
import com.ysj.mapper.FoodMapper;
import com.ysj.service.FoodService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Resource
    private FoodMapper foodMapper;

    @Override
    public List<Food> getAllFoodInfo() {
        return foodMapper.getAllFoodInfo();
    }

    @Override
    public List<Food> keyWordCheck(String search) {
        return foodMapper.keyWordCheck(search);
    }

    @Override
    public List<Food> getFoodInfoById(Integer id) {
        return foodMapper.getFoodInfoById(id);
    }

    @Override
    public List<Food> getFoodInfoByFid(String fid) {
        return foodMapper.getFoodInfoByFid(fid);
    }


}
