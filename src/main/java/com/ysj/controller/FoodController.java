package com.ysj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.common.Result;
import com.ysj.entity.Category;
import com.ysj.entity.Food;
import com.ysj.mapper.FoodMapper;
import com.ysj.service.CategoryService;
import com.ysj.service.FoodService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@CrossOrigin
@Controller
@RequestMapping("/food")
public class FoodController {
    @Resource
    FoodMapper FoodMapper;
    @Resource
    FoodMapper foodMapper;

    @Resource
    FoodService foodService;

    @Resource
    CategoryService categoryService;

//   新增
    @PostMapping
    public Result<?> save(@RequestBody Food food){
        FoodMapper.insert(food);
        return Result.success();
    }
//    更新
    @PutMapping
    public Result<?> update(@RequestBody Food food){
        FoodMapper.updateById(food);
        return Result.success();
    }
//    查询
    @GetMapping
    public Result<?> findPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Food> wrapper = Wrappers.<Food>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Food::getFoodName,search) ;
        }
        Page<Food> FoodPage = FoodMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(FoodPage);
    }
//    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable long id){
        FoodMapper.deleteById(id);
        return Result.success();
}
//    查询菜系名
    @GetMapping("/selectPatternInfo")
    public Result<?> selectPatternInfo(){
        List<Category> list =  categoryService.selectPatternInfo();
        return Result.success(list);
    }

    //查询全部食物信息
    @GetMapping("/getAllFoodInfo")
    public Result<?> getAllFoodInfo(){
        List<Food> list = foodMapper.getAllFoodInfo();
        return Result.success(list);
    }

    //按关键词查询食物信息
    @GetMapping("/keyWordCheck")
    public Result<?> keyWordCheck(@RequestParam(defaultValue = "") String search){
        List<Food> list = foodService.keyWordCheck(search);
        return Result.success(list);
    }

    //按id查询食物信息
    @GetMapping("/getFoodInfoById")
    public Result<?> getFoodInfoById(@RequestParam(defaultValue = "") Integer id){
        List<Food> list = foodService.getFoodInfoById(id);
        return Result.success(list);
    }

    @GetMapping("/getFoodInfoByFid")
    public Result<?> getFoodInfoByFid(@RequestParam(defaultValue = "") String fid){
        List<Food> list = foodService.getFoodInfoByFid(fid);
        return Result.success(list);
    }

}
