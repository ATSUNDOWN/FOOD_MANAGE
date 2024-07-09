package com.ysj.controller;

import com.ysj.common.Result;
import com.ysj.entity.Favorites;
import com.ysj.entity.Food;
import com.ysj.mapper.FavoritesMapper;
import com.ysj.service.FavoritesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@Controller
@RequestMapping("/favorites")
public class FavoritesController {
    @Resource
    private FavoritesService favoritesService;

    @GetMapping("/showFavorites")
    public Result<?> showFavorites(@RequestParam(defaultValue = "")String username){
        List<Food> list = favoritesService.showFavorites(username);
        return Result.success(list);
    }

    @GetMapping("/addCollection")
    public Result<?> addCollection(@RequestParam(defaultValue = "")String fid,@RequestParam(defaultValue = "")String username){
        favoritesService.addCollection(fid,username);
        return Result.success();
    }

    @GetMapping("/cancelFavorites")
    public Result<?> cancelFavorites(@RequestParam(defaultValue = "")String fid){
        favoritesService.cancelFavorites(fid);
        return Result.success();
    }
}
