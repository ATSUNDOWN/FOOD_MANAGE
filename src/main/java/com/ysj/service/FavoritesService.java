package com.ysj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysj.entity.Favorites;
import com.ysj.entity.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoritesService extends IService<Favorites> {
//    展示收藏夹信息
    List<Food> showFavorites(@Param("username") String username);
    //    将食品添入收藏夹
    void addCollection(@Param("fid") String fid,@Param("username") String username);
    //    取消收藏
    void cancelFavorites(@Param("fid") String fid);

}
